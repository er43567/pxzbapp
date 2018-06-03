package pxxy.liangming.pazbapp.net;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by asus on 2017/7/19.
 */

public class NetManager {

    static Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            INetCallback callback = (INetCallback) bundle.getSerializable("callback");
            try {
                String jsonResult = bundle.getString("jsonResult");
                JSONObject jsonObject;
                String result = "fail";
                jsonObject = new JSONObject(jsonResult);
                if(jsonResult != null) {
                    if (jsonObject.has("result"))
                        result = jsonObject.getString("result");
                    if(callback != null)
                        callback.onCallback(result,jsonObject);
                } else {
                    if (jsonObject.has("result"))
                        result = jsonObject.getString("result");
                    callback.onCallback(result,null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if(callback!=null)
                    callback.onCallback("fail",null);
            }
        }
    };

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void visit(final String url, final String args[], final String vals[], final INetCallback callback) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String httpResult;

                    if(args==null || vals==null) {
                        httpResult = HttpClientMine.post(url);
                    } else {
                        httpResult = HttpClientMine.post(url, args, vals);
                    }

                    Log.i("HTTPRESULT",httpResult+"");

                    Message msg = new Message();
                    Bundle bundle = new Bundle();
                    Log.i("*****postUrl",url);
                    bundle.putString("jsonResult", httpResult);
                    bundle.putSerializable("callback", callback);
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void visit(final String url, final INetCallback callback) {
        visit(url,null,null,callback);
    }

    public static void setCookieString(String cookie) {
        HttpClientMine.setCookieString(cookie);
    }

    public static String getCookieString() {
        return HttpClientMine.getCookieString();
    }

    public static void synWebCookies(Context context, String url, String cookie) {
        if (url == null) return;
        if (cookie == null) return;
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        //cookieManager.setCookie(HttpClientMine.getDomainString(), null);
        cookieManager.removeSessionCookie();
        cookieManager.setCookie(url, cookie);
        CookieSyncManager.getInstance().sync();
    }

    private void removeWebCookie(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public interface INetCallback extends Serializable {
        void onCallback(String result, JSONObject jsonObject);
    }

}

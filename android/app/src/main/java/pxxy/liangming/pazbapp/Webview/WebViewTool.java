package pxxy.liangming.pazbapp.Webview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.ValueCallback;
import android.webkit.WebView;

/**
 * Created by asus on 2018/3/23.
 */

public class WebViewTool {
    static WebView webView;
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void callJs(WebView webview, String js) {
        final int version = Build.VERSION.SDK_INT;
        if (version < 18) {
            webview.loadUrl("javascript:" + js);
        } else {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                webview.evaluateJavascript("javascript:" + js, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                    }
                });
            } else {
                webView = webview;
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("js", js);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }
    }

    static Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            webView.loadUrl("javascript:" + msg.getData().getString("js"));
            webView = null;
        }
    };

}

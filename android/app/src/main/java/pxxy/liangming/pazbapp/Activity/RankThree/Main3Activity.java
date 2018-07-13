package pxxy.liangming.pazbapp.Activity.RankThree;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.Arrays;

import pxxy.liangming.pazbapp.R;
import pxxy.liangming.pazbapp.Webview.MyJavascriptInterface;
import pxxy.liangming.pazbapp.Webview.MyWebViewChromeClient;
import pxxy.liangming.pazbapp.Webview.Tool;
import pxxy.liangming.pazbapp.Webview.WebViewActivity;
import pxxy.liangming.pazbapp.Webview.WebViewTool;

public class Main3Activity extends AppCompatActivity {

    public final static int REQUEST_FCR = 1;
    public final static int REQUEST_STRING = 2;
    public final static int RESULT_OK = 2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        /*init();*/
    }

    WebView webView;
    SwipeRefreshLayout refreshLayout;
    MyWebViewChromeClient myWebViewChromeClient;

    protected void init() {
        Intent intent = getIntent();
        String attrs[] = intent.getStringArrayExtra("attrs");
        initView();
        loadAttrs(webView, attrs);
        String url = intent.getStringExtra("url");
        Toast.makeText(this, "" + url, Toast.LENGTH_SHORT).show();
        webView.loadUrl(url);
    }

    private void loadAttrs(WebView webView, String[] attrs) {
        if(attrs == null) {
            attrs = new String[]{"norefresh"};
        }

        if(Arrays.asList(attrs).contains("norefresh")) {
            refreshLayout.setEnabled(false);
        } else if(Arrays.asList(attrs).contains("refresh")) {
            refreshLayout.setEnabled(true);
        }
    }

    void initView() {
        refreshLayout = findViewById(R.id.refreshLayout3);
        webView = findViewById(R.id.webView3);

        webView.setHorizontalScrollBarEnabled(false);//水平不显示
        webView.setVerticalScrollBarEnabled(false);//垂直不显示
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Tool.stopProcessing(refreshLayout);
                setTitle(view.getTitle());
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                view.clearHistory();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                view.clearHistory();
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(false);
        myWebViewChromeClient = new MyWebViewChromeClient(this, webView);
        myWebViewChromeClient.setSwipeRefreshLayout(refreshLayout);
        webView.setWebChromeClient(myWebViewChromeClient);
        webView.addJavascriptInterface(new MyJavascriptInterface(this, webView),"android");
        WebSettings ws = webView.getSettings();
        ws.setDefaultTextEncodingName("utf-8") ;
        ws.setAllowFileAccess(true);
        ws.setJavaScriptEnabled(true);
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        // 设置可以支持缩放
        ws.setSupportZoom(false);
        ws.setBuiltInZoomControls(true);
        ws.setDisplayZoomControls(false);
        ws.setUseWideViewPort(true);
        ws.setLoadWithOverviewMode(true);

        ws.setAppCacheEnabled(true);
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public static void start(Context context, String url, String attrs[]) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("url", url);
        if (attrs!=null) intent.putExtra("attrs", attrs);
        context.startActivity(intent);
    }

    String resultString;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_STRING && requestCode == RESULT_OK && data != null) {
            resultString = data.getStringExtra("result");
            WebViewTool.callJs(webView, "onActivityResult('"+resultString+"')");
        }
        if (REQUEST_FCR == requestCode) {
            myWebViewChromeClient.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    public void finish() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            saveAndExit();
        }
    }

    public void saveAndExit() {
        Main3Activity.super.finish();
    }

}

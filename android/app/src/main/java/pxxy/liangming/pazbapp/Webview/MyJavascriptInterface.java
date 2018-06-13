package pxxy.liangming.pazbapp.Webview;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import pxxy.liangming.pazbapp.Util.Dialog;
public class MyJavascriptInterface {
    private WebView webView;
    private Context context;

    public MyJavascriptInterface(Context c, WebView webView) {
        this.context = c;
        this.webView = webView;
    }

    @JavascriptInterface
    public void show(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void openChrome(String url) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        context.startActivity(intent);
    }

    @JavascriptInterface
    public void copy(String content) {
        ClipboardManager cm = (ClipboardManager) context
                .getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(content);
        Toast.makeText(context, "已复制", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void startActivity(String url) {
        WebViewActivity.start(context, url, null);
    }

    @JavascriptInterface
    public void startActivity(String url, String attrs[]) {
        WebViewActivity.start(context, url, attrs);
    }

    @JavascriptInterface
    public void closeActivity() {
        if (context instanceof WebViewActivity) {
            ((WebViewActivity) context).saveAndExit();
        }
    }

    @JavascriptInterface
    public void showListDialog(String li[], final String callback) {
        Dialog.showListDialog(context, li, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                WebViewTool.callJs(webView, callback + "('"+i+"')");
            }
        });
    }

    @JavascriptInterface
    public void showOkCancelDialog(String content, final String callback) {
        Dialog.showOKCancelDialog(context, content, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                WebViewTool.callJs(webView, callback + "('"+i+"')");
            }
        });
    }

    public String toString() {
    	return "android";
    }
}
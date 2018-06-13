package webview;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPreviewActivity;
import cn.lrxzl.libs.android.tool.Tool;
import cn.lrxzl.unclezhang.R;
import cn.lrxzl.unclezhang.managers.CacheManager;
import cn.lrxzl.unclezhang.managers.NetManager;
import cn.lrxzl.unclezhang.service.NoticeLoaderService;
import cn.lrxzl.webview.MyJavascriptInterface;
import cn.lrxzl.webview.WebViewTool;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class WebViewActivity extends AppCompatActivity {
    public final static int REQUEST_FCR = 1;
    public final static int REQUEST_STRING = 2;
    public final static int RESULT_OK = 2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_webview);
    }

    WebView webView;
    SwipeRefreshLayout refreshLayout;
    MyWebViewChromeClient myWebViewChromeClient;
    String currentUrl;
    protected void loadUrl(String url) {
        this.currentUrl = url;
        webView.loadUrl(url);
    }

    protected void loadDataWithBaseUrl(String baseUrl, String data,String mimeType,String encode) {
        webView.loadDataWithBaseURL(baseUrl, data, mimeType, encode, null);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String attrs[] = intent.getStringArrayExtra("attrs");
        initView(intent.getStringExtra("param"));
        loadAttrs(webView, attrs);
    }

    private void loadAttrs(WebView webView, String[] attrs) {
        if(attrs == null) {
            attrs = new String[]{"title","gesture","norefresh"};
        }
        if(Arrays.asList(attrs).contains("notitle")) {
            getSupportActionBar().hide();
        } else if(Arrays.asList(attrs).contains("title")) {
            getSupportActionBar().show();
        }

        if(Arrays.asList(attrs).contains("norefresh")) {
            refreshLayout.setEnabled(false);
        } else if(Arrays.asList(attrs).contains("refresh")) {
            refreshLayout.setEnabled(true);
        }
    }

    void initView(final String param) {
        refreshLayout = findViewById(R.id.refreshLayout);
        webView = findViewById(R.id.webView);

        webView.setHorizontalScrollBarEnabled(false);//水平不显示
        webView.setVerticalScrollBarEnabled(false);//垂直不显示
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //Toast.makeText(WebViewActivity.this, "onPageStarted " + CacheManager.getCookieString(), Toast.LENGTH_SHORT).show();
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //Tool.startProcessing(refreshLayout);
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Tool.stopProcessing(refreshLayout);
                setTitle(view.getTitle());
                /*//保存Cookie
                CookieManager cookieManager = CookieManager.getInstance();
                String CookieStr = cookieManager.getCookie(url);
                if (CookieStr != null) {
                    CacheManager.saveCookieString(CookieStr);
                    Toast.makeText(WebViewActivity.this, "saveCookie " + CookieStr, Toast.LENGTH_SHORT).show();
                }*/
                if (url.endsWith("!logoff")) {
                    CacheManager.removeAccount();
                    CacheManager.removeCookieString();
                }
                WebViewTool.callJs(webView, "onPageFinished('" + param + "')");
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                //Toast.makeText(WebViewActivity.this, "E1:糟糕~网络出现故障了", Toast.LENGTH_SHORT).show();
                //Toast.makeText(WebViewActivity.this, "" + webView.getUrl() + error.getDescription(), Toast.LENGTH_SHORT).show();
                /*if (view.getUrl().contains("main.jsp")) {
                    view.loadUrl("file:///android_asset/pages/main.html");
                    WebViewActivity.super.finish();
                }*/
                view.clearHistory();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                /*Toast.makeText(WebViewActivity.this, errorCode+"E2:糟糕~网络出现故障了", Toast.LENGTH_SHORT).show();
                Toast.makeText(WebViewActivity.this, "" + webView.getUrl(), Toast.LENGTH_SHORT).show();
                if (view.getUrl().contains("main.jsp")) {
                    view.loadUrl("file:///android_asset/pages/main.html");
                    WebViewActivity.super.finish();
                }*/
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
        webView.addJavascriptInterface(new MyJavascriptInterface(this, webView) {
                                           @JavascriptInterface
                                           public void showTitleBar(boolean bo) {
                                               if (bo) {
                                                   getSupportActionBar().show();
                                               } else {
                                                   getSupportActionBar().hide();
                                               }
                                           }
                                           @JavascriptInterface
                                           public void setFinishGesture(boolean bo) {
                                               setFinishGesture(bo);
                                           }
                                           @JavascriptInterface
                                           public void reviewImages(String imgs, int currentPos) {
                                               String spliter = ";";
                                               if (imgs.startsWith("data:image")) {
                                                   spliter = "##";
                                               }
                                               ArrayList<String> al = new ArrayList<>();
                                               String img[] = imgs.split(spliter);
                                               for (int i=0;i<img.length;i++) {
                                                   if (TextUtils.isEmpty(img[i])==false) {
                                                       al.add(img[i].trim());
                                                   }
                                               }
                                               if (al.size()>0) {
                                                   photoPreviewWrapper(al, currentPos);
                                               }
                                           }
                                           @JavascriptInterface
                                           public void setStatusBarTransparent() {
                                               runOnUiThread(new Runnable() {
                                                   @Override
                                                   public void run() {
                                                       WebViewActivity.this.setStatusBarTransparent();
                                                   }
                                               });
                                           }
                                       }
                    /*@JavascriptInterface
                    public void saveSource(String html) {
                        CacheManager.removeCache("mainPage");
                        Toast.makeText(WebViewActivity.this
                                , "" + StringEscapeUtils.unescapeJava(html)
                                , Toast.LENGTH_SHORT).show();
                        CacheManager.saveCache("mainPage", StringEscapeUtils.unescapeJava(html) + "");
                    }*/

                , "android");
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
    protected void setListener() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
                Tool.startProcessing(refreshLayout);
            }
        });
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        NoticeLoaderService.currentWebView = webView;
        WebViewTool.callJs(webView, "onResume()");
    }

    public static void start(Context context, String url, String attrs[], String param) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("url", url);
        if (attrs!=null) intent.putExtra("attrs", attrs);
        if (param!=null) intent.putExtra("param", param);
        ((WebViewActivity)context).startActivityForResult(intent, REQUEST_STRING);
    }

    public static void startWithoutResult(Context context, String url, String attrs[], String param) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("url", url);
        if (attrs!=null) intent.putExtra("attrs", attrs);
        if (param!=null) intent.putExtra("param", param);
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

    public void saveAndExit(String result) {
        setResult(RESULT_OK, new Intent().putExtra("result", result));
        saveAndExit();
    }

    @Override
    public void saveAndExit() {
        /*webView.evaluateJavascript("javascript:getSource()", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                value = value==null?"":value;
                CacheManager.saveCache(webView.getUrl(), value);
                WebViewActivity.super.finish();
            }
        });*/
        //webView.loadUrl("javascript:saveSource(document.documentElement.outerHTML)");
        WebViewActivity.super.finish();
    }


    /**
     * 图片预览，兼容6.0动态权限
     */
    @AfterPermissionGranted(1)
    private void photoPreviewWrapper(ArrayList<String> datas, int currentPos) {
        // 保存图片的目录，改成你自己要保存图片的目录。如果不传递该参数的话就不会显示右上角的保存按钮
        //File downloadDir = new File(Environment.getExternalStorageDirectory(), Conf.BASE_FOLDER_NAME);

        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            startActivity(BGAPhotoPreviewActivity.newIntent(this, null
                    , datas, currentPos));
        } else {
            EasyPermissions.requestPermissions(this, "图片预览需要以下权限:\n\n1.访问设备上的照片", 1, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {}
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (requestCode == 1) {
            Toast.makeText(this, "您拒绝了「图片预览」所需要的相关权限!", Toast.LENGTH_SHORT).show();
        }
    }


}

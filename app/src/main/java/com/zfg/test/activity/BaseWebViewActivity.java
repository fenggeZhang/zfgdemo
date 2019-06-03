package com.zfg.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zfg.test.R;
import com.zfg.test.utils.LogUtil;

/**
 * 关闭硬件加速（页面闪烁，出现白块现象）
 *
 * 动态添加
 */
public class BaseWebViewActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_web_view);
        mWebView = findViewById(R.id.my_webview);
        initWebView();
//绑定一个对象
        mWebView.addJavascriptInterface(this, "android_js_interface");
        mWebView.loadUrl("file:///android_asset/test.html");
//        mWebView.loadUrl("http://121.42.248.165:9001/appPage/MessageHandler.html");
        //步骤3. 复写shouldOverrideUrlLoading()方法，使得打开网页时不调用系统浏览器，
        // 而是在本WebView中显示
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
//        最低支持api 19
        /*mWebView.evaluateJavascript("", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                ou:
                break ou;
            }
        });*/
        LogUtil.e("zfg:onCreate");

    }

    private void initWebView() {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setSupportZoom(false);//是否支持缩放
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 隐藏缩放按钮
        webSettings.setDisplayZoomControls(false);

        //设置WebView对h5页面的支持
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setNeedInitialFocus(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setAllowContentAccess(true); // 是否可访问Content Provider的资源，默认值 true
        // 是否允许通过file url加载的Javascript读取本地文件，默认值 false
        webSettings.setAllowFileAccessFromFileURLs(false);
        // 是否允许通过file url加载的Javascript读取全部资源(包括文件,http,https)，默认值 false
        webSettings.setAllowUniversalAccessFromFileURLs(false);
    }

//要添加这个参数 并且方法名称要与前端js保持一致
    @JavascriptInterface
    public void GetAuthorizationList(String data) {
        LogUtil.e("test11:" + data);
    }


    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.e("zfg:onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.e("zfg:onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.e("zfg:onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.e("zfg:onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e("zfg:onDestroy");
        mWebView.destroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.e("zfg:onPause");
    }
}

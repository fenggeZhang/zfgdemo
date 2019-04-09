package com.zfg.test.kotlintest.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.zfg.test.R
import com.zfg.test.utils.LogUtil
import android.webkit.WebSettings
import com.zfg.test.MainActivity


/**
 * Created by zfg on 2018/6/20
 * 加载网页
 */
class BaseWebKotlin : AppCompatActivity() {
    lateinit var myWebview: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_web_view)
        myWebview = findViewById(R.id.my_webview)
        // 获取WebSetting对象
        val webSettings = myWebview.getSettings()
// 设置支持javascript
        webSettings.setJavaScriptEnabled(true)
// 将Android里面定义的类对象AndroidJs暴露给javascript

//        myWebview.addJavascriptInterface(new AndroidJs(m), "AndroidJs");
        myWebview.loadUrl("http://www.baidu.com")
        Log.e("zfg", "网页。。。")
        myWebview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        LogUtil.e("zfg:onCreate")
    }

    override fun onResume() {
        super.onResume()
        LogUtil.e("zfg:onResume")
    }

    override fun onRestart() {
        super.onRestart()
        LogUtil.e("zfg:onRestart")
    }

    override fun onStop() {
        super.onStop()
        LogUtil.e("zfg:onStop")
    }

    override fun onStart() {
        super.onStart()
        LogUtil.e("zfg:onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.e("zfg:onDestroy")
    }

    override fun onPause() {
        super.onPause()
        LogUtil.e("zfg:onPause")
    }
}
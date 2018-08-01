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
        myWebview.loadUrl("http://www.baidu.com")
        Log.e("zfg","网页。。。")
        myWebview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
    }
}
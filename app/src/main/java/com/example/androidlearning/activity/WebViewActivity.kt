package com.example.androidlearning.activity

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R

class WebViewActivity : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var proDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)
        proDialog = ProgressDialog(this)
        proDialog.setMessage("Loading please wait...")
        proDialog.setCancelable(false)
        proDialog.show()
        webView = findViewById(R.id.web_view)
        webView.loadUrl("https://developer.android.com/develop/ui/views/layout/webapps/webview")

        val myWebViewClient = MyWebViewClient()
        webView.webViewClient = myWebViewClient
    }


    inner class MyWebViewClient: WebViewClient(){
//        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//            return super.shouldOverrideUrlLoading(view, url)
//        }
//
//        override fun shouldOverrideUrlLoading(
//            view: WebView?,
//            request: WebResourceRequest?
//        ): Boolean {
//            return super.shouldOverrideUrlLoading(view, request)
//        }
//
//        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
//            super.onPageStarted(view, url, favicon)
//        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            proDialog.dismiss()
        }
    }
}
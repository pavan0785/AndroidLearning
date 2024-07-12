package com.example.androidlearning.activity

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlearning.R

class WebViewActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)
        webView = findViewById(R.id.web_view)
        webView.loadUrl("https://developer.android.com/develop/ui/views/layout/webapps/webview")
    }
}
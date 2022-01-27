package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://github.com/Kim-Min-Hyeok";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);//id 지정
        webView.getSettings().setJavaScriptEnabled(true);//Web세팅, 자바스크립트 허용
        webView.loadUrl(url);//url을 load해주는 메소드
        webView.setWebChromeClient(new WebChromeClient());//chrome을 쾌적하기 돌리기 위해 설정
        webView.setWebViewClient(new WebViewClientClass());

    }

    @Override//어떤 키를 눌렀을 때 일정 이벤트를 실행해주는 메소드(ctrl+o 하여 찾는다.-onKeyDown)
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {//뒤로가기 버튼(종료)
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {//현재페이지에 url을 읽을 수 있는 메소드
            view.loadUrl(url);
            return true;
        }
    }
}
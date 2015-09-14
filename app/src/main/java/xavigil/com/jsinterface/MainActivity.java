package xavigil.com.jsinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private static final String ASSET_NAME = "wifissid.html";

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView)findViewById(R.id.webview);
        setupWebView(mWebView);
        loadAsset(mWebView, ASSET_NAME);
    }

    private void setupWebView(WebView webView){
        if(webView == null) return;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JSInterface(this), "AndroidInterface");
    }

    private void loadAsset(WebView webview, String assetName){
        webview.loadUrl("file:///android_asset/"+assetName);
    }

}

package action1020.com.naver.blog.splashwebview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;
    private long waitForToast = 0;
    private int duration = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://naver.com");
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setInitialScale(1);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setUseWideViewPort(true);

        final Activity MyActivity = this;
        myWebView.setWebChromeClient(new WebChromeClient()
        {
            public void onProgressChanged(WebView view, int progress)
            {
                MyActivity.setTitle("Loading...");
                MyActivity.setProgress(progress * 100);

                if(progress == 100)
                    MyActivity.setTitle(R.string.app_name);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if ( myWebView.isFocused() && myWebView.canGoBack() ){
            myWebView.goBack();
        }else{

            if ( System.currentTimeMillis() > waitForToast + duration ){
                waitForToast = System.currentTimeMillis();
                Toast.makeText(this, "'뒤로' 버튼 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
            }else {
                finish();
            }

        }

    }
}
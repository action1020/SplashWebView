package action1020.com.naver.blog.splashwebview;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "이영호님의 개인 네이버가 로딩되었습니다!", Toast.LENGTH_SHORT).show();

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

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setTitle("이영호님의 네이버");
            builder.setMessage("프로그램을 종료하시겠습니까?");

            builder.setPositiveButton("네", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }

            });

            builder.setNegativeButton("아니요", null);
            builder.show();

        }

    }
}
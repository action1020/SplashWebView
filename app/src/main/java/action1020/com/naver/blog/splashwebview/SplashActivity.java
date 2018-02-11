package action1020.com.naver.blog.splashwebview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by action1020 on 2018. 2. 6..
 */

public class SplashActivity extends AppCompatActivity {

    public static String TAG = "Splash";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: loaded.");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        finish();

        Log.d(this.toString(), "onCreate: finished.");
    }
}
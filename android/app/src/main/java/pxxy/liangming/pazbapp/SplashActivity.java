package pxxy.liangming.pazbapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pxxy.liangming.pazbapp.Activity.LoginActivity;
import pxxy.liangming.pazbapp.Activity.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent =new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }
}

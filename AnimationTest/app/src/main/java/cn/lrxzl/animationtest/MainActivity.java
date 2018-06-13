package cn.lrxzl.animationtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyImageButton button = findViewById(R.id.aa);
        button.setAnimColor(Color.BLUE);//颜色
        button.fromAlpha(30);//最小透明度 （0到100）
        button.toAlpha(60);//最大透明度 （0到100）
        button.setRadius(150);//设置当前半径
        button.setFadeSpeed(2.0f);//设置消失速度
    }

}

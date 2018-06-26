package pxxy.liangming.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tv;
        tv=findViewById(R.id.tv);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tv.setText(title);
    }
}

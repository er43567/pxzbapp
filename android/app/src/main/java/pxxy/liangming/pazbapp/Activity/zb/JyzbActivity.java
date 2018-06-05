package pxxy.liangming.pazbapp.Activity.zb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pxxy.liangming.pazbapp.R;

public class JyzbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peisw_jiuyuanzb);
        Button commit;
        commit=findViewById(R.id.confirm);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"数据保存成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

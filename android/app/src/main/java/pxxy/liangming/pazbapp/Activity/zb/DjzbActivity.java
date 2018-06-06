package pxxy.liangming.pazbapp.Activity.zb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pxxy.liangming.pazbapp.R;


/**
 * Created by Liangming on 2018/5/14 0020.
 */

public class DjzbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiaxc_danjingzb);

        initWidgets();


    }

    /**
     * 所有的组建初始化
     */
    private void initWidgets() {
        Button commit = findViewById(R.id.confirm);

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"数据保存成功",Toast.LENGTH_SHORT).show();
            }
        });
    }


}

package pxxy.liangming.pazbapp.Activity.zb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Arrays;

import pxxy.liangming.pazbapp.R;
import pxxy.liangming.pazbapp.Util.Dialog;
import pxxy.liangming.pazbapp.net.NetAdapterLrx;
import pxxy.liangming.pazbapp.net.NetManager;


/**
 * Created by Liangming on 2018/5/14 0020.
 */

public class FhzbActivity extends AppCompatActivity {

    int radioGroups[] = new int[]{
            R.id.rg_1,
            R.id.rg_2,
            R.id.rg_3,
            R.id.rg_4,
            R.id.rg_5,
            R.id.rg_6
    };
    int selections[] = new int[radioGroups.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhangyw_fanghuzhuangbei);

        initWidgets();

    }

    /**
     * 所有的组建初始化
     */
    private void initWidgets() {
        //初始化所有RadioGroup的监听器
        for (int i=0;i<radioGroups.length;i++) {
            final int k = i;
            final RadioGroup r = findViewById(radioGroups[i]);
            r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    selections[k] = radioGroup.indexOfChild(r.findViewById(i));
                }
            });
        }

    }

    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            submit();
        }
    }

    void submit() {
        Dialog.showDialog(this, Arrays.toString(selections));
        NetAdapterLrx.submitFhzb(selections[0],selections[1],selections[2]
                ,selections[3],selections[4],selections[5], new NetManager.INetCallback(){
                    @Override
                    public void onCallback(String result, JSONObject jsonObject) {
                        if ("success".equals(result)) {
                            Toast.makeText(FhzbActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                            FhzbActivity.super.finish();
                        }
                    }
                });
    }
}

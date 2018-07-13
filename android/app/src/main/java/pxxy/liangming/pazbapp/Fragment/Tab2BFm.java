package pxxy.liangming.pazbapp.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.leon.lib.settingview.LSettingItem;

import java.text.SimpleDateFormat;
import java.util.Date;

import pxxy.liangming.pazbapp.Activity.LoginActivity;
import pxxy.liangming.pazbapp.Activity.car.CarActivity;
import pxxy.liangming.pazbapp.Activity.zb.DjzbActivity;
import pxxy.liangming.pazbapp.Activity.zb.DljtActivity;
import pxxy.liangming.pazbapp.Activity.zb.FhzbActivity;
import pxxy.liangming.pazbapp.Activity.zb.FzzbActivity;
import pxxy.liangming.pazbapp.Activity.zb.JsdjActivity;
import pxxy.liangming.pazbapp.Activity.zb.JyzbActivity;
import pxxy.liangming.pazbapp.Activity.zb.WqjxActivity;
import pxxy.liangming.pazbapp.R;
import pxxy.liangming.pazbapp.Titlebar.TitleBar;
import pxxy.liangming.pazbapp.Webview.WebViewActivity;

/**
 * Created by Liangming on 2018/6/7 0007.
 * Liangming 版权所有.
 * For project: android
 * In package: pxxy.liangming.pazbapp.Activity.RankTwo
 */

public class Tab2BFm extends Fragment {
    private static final String fileName = "login";//定义sp保存的文件的名称
    private TitleBar titleBarB;
    private String domain="127.0.0.1";
    private Button tab2_b_btn;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
         SharedPreferences shareGet=this.getActivity().getSharedPreferences(fileName,
                 Context.MODE_PRIVATE);
        String username=shareGet.getString("user", "");
        String password=shareGet.getString("pswd", "");
        System.out.println("BBBBBBBBBBB____onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("BBBBBBBBBBB____onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("BBBBBBBBBBB____onCreateView");
        return inflater.inflate(R.layout.tab2_b, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("BBBBBBBBBBB____onActivityCreated");

        Date date=new Date();//获得系统当前的时间
//      long date=(long)24979599*60000;    //任意毫秒数，可以parse转化为日期类型后getTime获取
//      long date=1498838705129l;
        System.out.println(date);
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        String form=sd.format(date);

        titleBarB=(TitleBar) getView().findViewById(R.id.title2_barB);
        titleBarB.setTitle("装备检查"+"\n["+form+"]");
        titleBarB.setTitleColor(Color.WHITE);
tab2_b_btn=getView().findViewById(R.id.tab2_b_btn1);
tab2_b_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        WebViewActivity.start(getActivity() ,"http://127.0.0.1:8020/zbgl_h5/pages/r2_main.html", null);
    }
});


        /*
        给fagment按钮添加事件*/
/*
        this.getView().findViewById(R.id.clickme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获得绑定的FragmentActivity
                MainActivity activity = ((MainActivity)getActivity());
                // 获得TabAFm的控件
     */
/*           EditText editText = (EditText) activity.fragments.get(0).getView().findViewById(R.id.edit);*//*

*/
/*
                Toast.makeText(activity, activity.hello + editText.getText(), Toast.LENGTH_SHORT).show();*//*

            }
        });
*/
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("BBBBBBBBBBB____onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("BBBBBBBBBBB____onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("BBBBBBBBBBB____onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("BBBBBBBBBBB____onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("BBBBBBBBBBB____onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("BBBBBBBBBBB____onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("BBBBBBBBBBB____onDetach");
    }

}

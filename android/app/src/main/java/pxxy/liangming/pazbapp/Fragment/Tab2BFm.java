package pxxy.liangming.pazbapp.Fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leon.lib.settingview.LSettingItem;

import java.text.SimpleDateFormat;
import java.util.Date;

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

/**
 * Created by Liangming on 2018/6/7 0007.
 * Liangming 版权所有.
 * For project: android
 * In package: pxxy.liangming.pazbapp.Activity.RankTwo
 */

public class Tab2BFm extends Fragment {
    TitleBar titleBarB;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
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
        return inflater.inflate(R.layout.tab_b, container, false);
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

        titleBarB=(TitleBar) getView().findViewById(R.id.title_barB);
        titleBarB.setTitle("装备情况检查"+"\n["+form+"]");

 /*       LSettingItem djzb = (LSettingItem) getView().findViewById(R.id.djzb);
        LSettingItem fhzb = (LSettingItem) getView().findViewById(R.id.fhzb);
        LSettingItem jyzb = (LSettingItem) getView().findViewById(R.id.jyzb);
        LSettingItem dljt = (LSettingItem) getView().findViewById(R.id.dljt);
        LSettingItem wqjx = (LSettingItem) getView().findViewById(R.id.wqjx);
        LSettingItem jsdj = (LSettingItem) getView().findViewById(R.id.jsdj);
        LSettingItem fzzb = (LSettingItem) getView().findViewById(R.id.fzzb);
        LSettingItem car = (LSettingItem) getView().findViewById(R.id.car);

        final Intent toDjzb =new Intent(getContext(),DjzbActivity.class);
        final Intent toFhzb =new Intent(getContext(),FhzbActivity.class);
        final Intent toJyzb =new Intent(getContext(),JyzbActivity.class);
        final Intent toDljt =new Intent(getContext(),DljtActivity.class);
        final Intent toWqjx =new Intent(getContext(),WqjxActivity.class);
        final Intent toJsdj =new Intent(getContext(),JsdjActivity.class);
        final Intent toFzzb =new Intent(getContext(),FzzbActivity.class);
        final Intent toClgl =new Intent(getContext(),CarActivity.class);
        djzb.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                startActivity(toDjzb);
            }
        });
        fhzb.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                startActivity(toFhzb);
            }
        });
        jyzb.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                startActivity(toJyzb);
            }
        });
        dljt.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                startActivity(toDljt);
            }
        });
        wqjx.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                startActivity(toWqjx);
            }
        });
        jsdj.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                startActivity(toJsdj);
            }
        });
        fzzb.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click() {
                startActivity(toFzzb);
            }
        });*/
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

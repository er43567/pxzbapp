package pxxy.liangming.pazbapp.Fragment;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import pxxy.liangming.pazbapp.Util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import pxxy.liangming.pazbapp.R;
import pxxy.liangming.pazbapp.Titlebar.TitleBar;

import static pxxy.liangming.pazbapp.Util.DateUtil.getDay;

/**
 * Created by Liangming on 2018/5/17 0020.
 */

public class TabAFm extends Fragment{
    TitleBar titleBarA,titleBarB,titleBarC;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println("AAAAAAAAAA____onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("AAAAAAAAAA____onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("AAAAAAAAAA____onCreateView");
        return inflater.inflate(R.layout.tab_a, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
//获取当前时间


/*        simpleDateFormat.setText("Date获取当前日期时间"+simpleDateFormat.format(date));*/


        Date date=new Date();//获得系统当前的时间
//      long date=(long)24979599*60000;    //任意毫秒数，可以parse转化为日期类型后getTime获取
//      long date=1498838705129l;
        System.out.println(date);
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        String form=sd.format(date);
        Toast.makeText(getContext(),"加载完成",Toast.LENGTH_SHORT).show();

        titleBarA=(TitleBar) getActivity().findViewById(R.id.title_barA);
        titleBarA.setTitle("今日公告"+"\n["+form+"]");

        titleBarA.setTitleColor(Color.WHITE);

        System.out.println("AAAAAAAAAA____onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();

        System.out.println("AAAAAAAAAA____onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("AAAAAAAAAA____onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("AAAAAAAAAA____onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("AAAAAAAAAA____onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("AAAAAAAAAA____onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("AAAAAAAAAA____onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("AAAAAAAAAA____onDetach");
    }
}

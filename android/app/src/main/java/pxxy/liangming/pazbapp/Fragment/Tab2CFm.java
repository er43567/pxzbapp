package pxxy.liangming.pazbapp.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pxxy.liangming.pazbapp.Activity.LoginActivity;
import pxxy.liangming.pazbapp.R;
import pxxy.liangming.pazbapp.Titlebar.TitleBar;

/**
 * Created by Liangming on 2018/6/7 0007.
 * Liangming 版权所有.
 * For project: android
 * In package: pxxy.liangming.pazbapp.Activity.RankTwo
 */

public class Tab2CFm extends Fragment {
    TitleBar titleBar2C;
    Button exit2Btn;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println("CCCCCCCCCC____onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("CCCCCCCCCC____onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("CCCCCCCCCC____onCreateView");
        return inflater.inflate(R.layout.tab2_c, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("CCCCCCCCCC____onActivityCreated");
        exit2Btn=getView().findViewById(R.id.exit2Btn);
        exit2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit=new Intent(getContext(), LoginActivity.class);
                startActivity(exit);
                getActivity().finish();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        titleBar2C=(TitleBar) getView().findViewById(R.id.title2_barC);
        titleBar2C.setTitle("我的账户");
        titleBar2C.setTitleColor(Color.WHITE);
        System.out.println("CCCCCCCCCC____onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("CCCCCCCCCC____onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("CCCCCCCCCC____onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("CCCCCCCCCC____onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("CCCCCCCCCC____onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("CCCCCCCCCC____onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("CCCCCCCCCC____onDetach");
    }




}

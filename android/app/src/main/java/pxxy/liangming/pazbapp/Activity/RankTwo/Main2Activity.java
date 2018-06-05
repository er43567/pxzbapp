package pxxy.liangming.pazbapp.Activity.RankTwo;
import pxxy.liangming.pazbapp.Adapter.FragmentTabAdapter;
import pxxy.liangming.pazbapp.Fragment.TabAFm;
import pxxy.liangming.pazbapp.Fragment.TabBFm;
import pxxy.liangming.pazbapp.Fragment.TabCFm;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;


import java.util.ArrayList;
import java.util.List;

import pxxy.liangming.pazbapp.R;

public class Main2Activity extends AppCompatActivity {
    private RadioGroup rgs;
    public List<Fragment> fragments = new ArrayList<Fragment>();

    public String hello = "hello ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragments.add(new TabAFm());
        fragments.add(new TabBFm());
        fragments.add(new TabCFm());
        rgs = (RadioGroup) findViewById(R.id.tabs_rg);

        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this, fragments, R.id.tab_content, rgs);

    }


}

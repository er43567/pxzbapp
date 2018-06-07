package pxxy.liangming.pazbapp.Activity.RankTwo;
import pxxy.liangming.pazbapp.Adapter.FragmentTabAdapter;
import pxxy.liangming.pazbapp.Fragment.Tab2AFm;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;


import java.util.ArrayList;
import java.util.List;

import pxxy.liangming.pazbapp.Fragment.Tab2BFm;
import pxxy.liangming.pazbapp.Fragment.Tab2CFm;
import pxxy.liangming.pazbapp.R;

public class Main2Activity extends AppCompatActivity {
    private RadioGroup rgs;
    public List<Fragment> fragments = new ArrayList<Fragment>();

    public String hello = "hello ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragments.add(new Tab2AFm());
        fragments.add(new Tab2BFm());
        fragments.add(new Tab2CFm());
        rgs = (RadioGroup) findViewById(R.id.tabs2_rg);

        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this, fragments, R.id.tab2_content, rgs);

    }


}

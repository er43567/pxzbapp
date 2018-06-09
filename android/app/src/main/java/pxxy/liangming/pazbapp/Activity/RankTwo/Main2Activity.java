package pxxy.liangming.pazbapp.Activity.RankTwo;
import pxxy.liangming.pazbapp.Adapter.FragmentTabAdapter;
import pxxy.liangming.pazbapp.Fragment.Tab2AFm;
import pxxy.liangming.pazbapp.Fragment.Tab2BFm;
import pxxy.liangming.pazbapp.Fragment.Tab2CFm;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import pxxy.liangming.pazbapp.R;

public class Main2Activity extends AppCompatActivity {
    private RadioGroup rgs2;
    public List<Fragment> fragments2 = new ArrayList<Fragment>();

    public String hello = "hello ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragments2.add(new Tab2AFm());
        fragments2.add(new Tab2BFm());
        fragments2.add(new Tab2CFm());
        rgs2 = (RadioGroup) findViewById(R.id.tabs2_rg);

        FragmentTabAdapter tabAdapter2 = new FragmentTabAdapter(this, fragments2, R.id.tab2_content, rgs2);

    }


}

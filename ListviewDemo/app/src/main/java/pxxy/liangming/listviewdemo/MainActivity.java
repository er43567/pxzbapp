package pxxy.liangming.listviewdemo;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    MyDataBaseHelper myDataBaseHelper;
    String DataBase_Name="lm.db";
    String Table_Name = "lmtable";
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //6.0运权
        verifyStoragePermissions(MainActivity.this);

        //初始化数据库并插入demo数据
        String titledemo="1";
        String contextdemo="aa";
        myDataBaseHelper = new MyDataBaseHelper(MainActivity.this, DataBase_Name, 2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("titleDemo", titledemo);
        contentValues.put("contextDemo",contextdemo);
        SQLiteDatabase db = myDataBaseHelper.getWritableDatabase();
        long id = db.insert(Table_Name, null, contentValues);
        db.close();
        if (id != -1) Toast.makeText(MainActivity.this, "插入成功", Toast.LENGTH_SHORT).show();
        else Toast.makeText(MainActivity.this, "插入失败", Toast.LENGTH_SHORT).show();



        final ListView lv=(ListView) findViewById(R.id.lv);
        ArrayList urls=new ArrayList<>();
        List<Map<String,Object>> datalist=new ArrayList<Map<String,Object>>();


        Map<String,Object> map1=new HashMap<String,Object>();
        map1.put("image",R.mipmap.ic_launcher);
        map1.put("title","我是一号");
        map1.put("context","11");
        Map<String,Object> map2=new HashMap<String,Object>();
        map2.put("image",R.mipmap.ic_launcher);
        map2.put("title","我是二号");
        map2.put("context","22");
        Map<String,Object> map3=new HashMap<String,Object>();
        map3.put("image",R.mipmap.ic_launcher);
        map3.put("title","我是三号");
        map3.put("context","33");
        //查询数据库，这里只是按照你的要求做了个demo并没有把拿到的数据解析并插进去，扩展你的脑洞
        searchDataBase(myDataBaseHelper.getReadableDatabase());
        Map<String,Object> map4=new HashMap<String,Object>();
        map4.put("image",R.mipmap.ic_launcher);
        map4.put("title","我是四号");
        map4.put("context","44");

        datalist.add(map1);
        datalist.add(map2);
        datalist.add(map3);
        datalist.add(map4);

        /*
        * 加载listview数据
        * */
        lv.setAdapter(new SimpleAdapter(this,datalist,R.layout.list_item,new String[]{"image","title","context"},new int[]{R.id.image,R.id.title,R.id.context}));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
            {
                HashMap<String,String> map=(HashMap<String,String>)lv.getItemAtPosition(p3);
                String title=map.get("title");
                String context=map.get("context");
                Toast.makeText(getApplicationContext(),
                        "你选择了第"+p3+"个Item，\nTitle的值是："+title+"\nitemContent的值是:"+context,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("title", title+"");
                startActivity(intent);
                finish();
            }


        });


    }
    //提取数据库数据的方法
    private String searchDataBase(SQLiteDatabase db) {
        Cursor cursor=db.query("imagetable", new String[]{"titledemo","contextdemo"}, null, null, null, null, null);
        String td = "";
        String cd = "";
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {
            td = cursor.getString(0) + "\n";
            cd = cursor.getString(1) + "\n";
        }
        cursor.close();
        db.close();
        String s = td +cd;
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        return s;
    }
    //sh
    public static void verifyStoragePermissions(Activity activity) {
        // 检查6.0运权
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            //没权限要给
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }
}

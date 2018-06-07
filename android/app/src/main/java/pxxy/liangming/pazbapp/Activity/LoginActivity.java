package pxxy.liangming.pazbapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import pxxy.liangming.pazbapp.Activity.RankTwo.Main2Activity;
import pxxy.liangming.pazbapp.R;
import pxxy.liangming.pazbapp.SplashActivity;
import pxxy.liangming.pazbapp.Titlebar.TitleBar;
import pxxy.liangming.pazbapp.Util.Dialog;
import pxxy.liangming.pazbapp.Util.SpUtil;
import pxxy.liangming.pazbapp.net.NetAdapterLrx;
import pxxy.liangming.pazbapp.net.NetManager;

/**
 * Created by Liangming on 2018/5/12 0020.
 * 登陆界面
 */

public class LoginActivity extends Activity {
    private static final String fileName = "login";//定义保存的文件的名称
    private Spinner mSpinner;
    private String role=null;
    private String userId=null;
    private String pswd=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //加载完界面以后，获取控件
        Button login =findViewById(R.id.loginBtn);
        EditText editText = findViewById(R.id.et_userId);
        EditText pswText = findViewById(R.id.et_pass);

//新建一个SP，检查是否有用户名密码存在，在则自动登陆
            SharedPreferences shareGet = super.getSharedPreferences(fileName,
                    MODE_PRIVATE);
            editText.setText(shareGet.getString("user", "null"));
            pswText.setText(shareGet.getString("pswd", ""));

            Toast.makeText(getApplicationContext()
                    ,"user:"+shareGet.getString("user", "")+"/"+shareGet.getString("pswd", "")
                    ,Toast.LENGTH_SHORT).show();




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.et_userId);
                EditText pswText = findViewById(R.id.et_pass);

                userId = editText.getText().toString();
                pswd = pswText.getText().toString();


                mSpinner = (Spinner) findViewById(R.id.spinner);

                String []sss=new String[]{"请选择账户","一级民警","二级"};

                //设置ArrayAdapter内置的item样式-这里是单行显示样式
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sss);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                //设置Adapter了
                mSpinner.setAdapter(adapter);
                //监听Spinner的操作
                mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    //选取时候的操作

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getApplication(),"itemSelected",Toast.LENGTH_SHORT).show();
                        role= (String) mSpinner.getSelectedItem();
                    }
                    //没被选取时的操作
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Toast.makeText(getApplication(),"noThingSelected",Toast.LENGTH_SHORT).show();

                    }
                });
                SharedPreferences share = getSharedPreferences(fileName, MODE_PRIVATE);
                SharedPreferences.Editor editor = share.edit();
                editor.putString("user", userId);
                editor.putString("pswd", pswd);
                editor.putString("role", role);
                editor.commit();

                Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();



                NetAdapterLrx.login(userId , psw, new NetManager.INetCallback() {
                    @Override
                    public void onCallback(String result, JSONObject jsonObject) {

                        if ("success".equals(result)) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);

                            finish();

                        } else {
                            Dialog.showDialog(LoginActivity.this, result + "");
                        }
                        //TODO 存账号密码

                    }
                });

            }
        });





    }

        /*NetAdapterLrx.loadDemoData("aslfsadf", new NetManager.INetCallback() {

            @Override
            public void onCallback(String result, JSONObject jsonObject) {
                Dialog.showDialog(LoginActivity.this, result + "");
                JSONArray ja = jsonObject.optJSONArray("userLi");
                Dialog.showDialog(LoginActivity.this, "len=" + ja.length() + "");
                JSONObject item = (JSONObject) ja.opt(0);
                Dialog.showDialog(LoginActivity.this,  item.optString("userId"));



                if ("success".equals(result)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                if (jsonObject != null)

                    Dialog.showDialog(LoginActivity.this, jsonObject.toString());
                    Toast.makeText(getApplicationContext(),"服务器：登陆成功",Toast.LENGTH_SHORT).show();
                }

                else {
                    Dialog.showDialog(LoginActivity.this, "NULL");}

            }
        });*/


/*    private static final String TAG = "login";
    Button loginBtn = null;
    EditText useridEt = null;
    EditText passEt = null;
    TextView promptText = null;
    @Override
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);*/
/*    loginBtn = (Button) findViewById(R.id.loginBtn);
    loginBtn.setOnClickListener(this);*/
   /* useridEt = (EditText) findViewById(R.id.userId);
    passEt = (EditText) findViewById(R.id.pass);
    promptText = (TextView) findViewById(R.id.promptText);
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .build();
    OkHttpUtils.initClient(okHttpClient);

    @Override
    public void onClick(View v) {
        String userid = useridEt.getText().toString().trim();
        String pass = passEt.getText().toString().trim();
        if(userid.equals("")){
            promptText.setText(R.string.userIdError);
            return ;
        }
        if(pass.equals("")){
            promptText.setText(R.string.passError);
            return ;
        }
        WebConstant.digest = ("Basic " + new String(Base64.encode((userid + ':' + pass).getBytes(), Base64.DEFAULT))).replace("\n", "");

        String url = WebConstant.REQUESTPATH+"/users/" + userid+"?getAll=true";
        OkHttpUtils.get()
                .url(url).addHeader("Authorization", WebConstant.digest).addHeader("Accept-Language","zh-CN")
                .build().execute(new Callback()
        {
            @Override
            public String parseNetworkResponse(Response response, int id) throws Exception {
                String string = response.body().string();
                JSONObject jsonObj = new JSONObject(string);
                if(jsonObj.get("userName")!=null){
                    WebConstant.userId = (String)jsonObj.get("userId");
                    WebConstant.userName = (String)jsonObj.get("userName");
                    return (String) jsonObj.get("userName");
                }
                return null;
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                WebConstant.digest = null;
                promptText.setText(R.string.loginError);
                Log.i(TAG,e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onResponse(Object response, int id) {
                promptText.setText(R.string.loginSuccess+" "+response);
                Intent intent = new Intent();
                LoginActivity.this.setResult(WebConstant.RESULT_OK, intent);
                LoginActivity.this.finish();
            }
        });

    }*/
}
package pxxy.liangming.pazbapp.Activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Properties;

import pxxy.liangming.pazbapp.Activity.RankThree.Main3Activity;
import pxxy.liangming.pazbapp.Activity.RankTwo.Main2Activity;
import pxxy.liangming.pazbapp.R;
import pxxy.liangming.pazbapp.Util.Dialog;
import pxxy.liangming.pazbapp.Util.SpUtil;
import pxxy.liangming.pazbapp.Webview.WebViewActivity;
import pxxy.liangming.pazbapp.net.NetAdapterLrx;
import pxxy.liangming.pazbapp.net.NetConfigUtil;
import pxxy.liangming.pazbapp.net.NetManager;

/**
 * Created by Liangming on 2018/5/12 0020.
 * 登陆界面
 */

public class LoginActivity extends Activity {
    private static Context mContext;
    private static final String fileName = "login";//定义保存的文件的名称
    private Spinner mSpinner;
    private String role=null;
    private String userId=null;
    private String pswd=null;
    private String select=null;
    private int autoLogin=0;
    private CheckBox autoLoginCB=null;
    String head=null;
    String domain=null;
    String port=null;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO 获取注销时是否传进“清除自动登陆”选项
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
        Toast.makeText(getApplicationContext(),"注销成功",Toast.LENGTH_SHORT)
        .show();
        //Todo 清除sp
            autoLogin=0;
        }

        SpUtil.init(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

/*        Dialog.showOKCancelDialog(this, "是否进入Webview Demo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                WebViewActivity.start(LoginActivity.this ,"http://11.10.10.4:8020/zbgl_h5/pages/r2_main.html", null);
            }
        });*/
        mContext = getApplicationContext();
        //加载完界面以后，获取控件
        Button login =findViewById(R.id.loginBtn);
        EditText editText = findViewById(R.id.et_userId);
        EditText pswText = findViewById(R.id.et_pass);
        Button testBtn=findViewById(R.id.testbtn);
        autoLoginCB=findViewById(R.id.autoLogin);
        //新建一个SP，检查是否有用户名密码存在，在则自动登陆



            SharedPreferences shareGet = super.getSharedPreferences(fileName,
                    MODE_PRIVATE);
            autoLogin=shareGet.getInt("autoLogin",0);

            editText.setText(shareGet.getString("user", ""));
            pswText.setText(shareGet.getString("pswd", ""));



        mSpinner = (Spinner) findViewById(R.id.spinner);
        //监听Spinner的操作
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //选取时候的操作

            @Override
            public void onItemSelected( AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                role = getResources().getStringArray(R.array.role)[arg2];

            }
            //没被选取时的操作
            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Properties properties=NetConfigUtil.getProperties();
                head= properties.getProperty("HEAD");
                domain= properties.getProperty("DOMAIN");
                port=properties.getProperty("PORT");
                if (autoLoginCB.isChecked()) {
                    autoLogin=1;
                }
                switch (autoLogin){
                    case 0:
                        break;
                    case 1:
                        SharedPreferences share = getSharedPreferences(fileName, MODE_PRIVATE);
                        SharedPreferences.Editor editor = share.edit();
                        editor.putString("user", userId);
                        editor.putString("pswd", pswd);
                        editor.putString("role", role);
                        editor.putInt("autoLogin",1);
                        editor.commit();

                }
                switch (role){
                    case "一级民警":

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;

                    case "二级大队长":
                        Intent main2=new Intent(LoginActivity.this,Main2Activity.class);
                        startActivity(main2);
                        finish();
                        break;
                    case "三级保障科":
                        Main3Activity.start(LoginActivity.this ,head+domain+port+"/zbgl_h5/pages/r3_main.html", null);
                        finish();
                        break;
                        default:
                            Toast.makeText(getApplication(),"请选择账户类型",Toast.LENGTH_SHORT).show();


                }
                EditText editText = findViewById(R.id.et_userId);
                EditText pswText = findViewById(R.id.et_pass);

                userId = editText.getText().toString();
                pswd = pswText.getText().toString();

//根据checkbox判断是否自动登陆




                NetAdapterLrx.login(userId , pswd, new NetManager.INetCallback() {
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
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.start(LoginActivity.this ,"http://www.baidu.com", null);
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
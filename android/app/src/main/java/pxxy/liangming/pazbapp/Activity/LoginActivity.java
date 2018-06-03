package pxxy.liangming.pazbapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import pxxy.liangming.pazbapp.R;
import pxxy.liangming.pazbapp.SplashActivity;
import pxxy.liangming.pazbapp.Titlebar.TitleBar;

/**
 * Created by Liangming on 2018/5/12 0020.
 */

public class LoginActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login =findViewById(R.id.loginBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(),"登陆成功",Toast.LENGTH_SHORT).show();
            }
        });

    }
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
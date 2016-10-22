package com.lenovo.jifu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by lenovo on 2016/10/12.
 */
public class RegisterActivity extends AppCompatActivity {
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private EditText editText;
    private Button button2;
    private CheckBox checkBox3;

    String APPKEY="1832d07a735a6";
    String APPSECRETE="5d29aa0efde291349844cd381f71b4d8";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化
        SMSSDK.initSDK(this,APPKEY,APPSECRETE);
        //配置信息
        textView5=(TextView)findViewById(R.id.textView5);
        textView6=(TextView)findViewById(R.id.textView6);
        textView7=(TextView)findViewById(R.id.textView7);
        textView8=(TextView)findViewById(R.id.textView8);
        textView9=(TextView)findViewById(R.id.textView9);

        button2=(Button)findViewById(R.id.button2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        checkBox3.setChecked(true);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterPage registerPage=new RegisterPage();
                //注册回调事件
                registerPage.setRegisterCallback(new EventHandler(){
                    @Override
                    //事件完成后调用
                    public void afterEvent(int event, int result, Object data) {
                        if(result==SMSSDK.RESULT_COMPLETE){
                            HashMap<String,Object> maps=(HashMap<String,Object>)data;
                            //国家
                           String country=(String)maps.get("country");
                            //手机号
                            String phone=(String)maps.get("phone");
                            submitUserInfo(country,phone);

                        }
                    }
                });
                //显示注册界面
                registerPage.show(RegisterActivity.this);

            }

        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    public void submitUserInfo( String country,String phone){
        Random r=new Random();
        String uid=Math.abs(r.nextInt())+"";
        String nickName="JUFU";
      SMSSDK.submitUserInfo(uid,nickName,null,country,phone);
    }
}

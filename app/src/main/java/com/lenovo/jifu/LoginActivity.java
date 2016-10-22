package com.lenovo.jifu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lenovo on 2016/10/12.
 */
public class LoginActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private CheckBox checkBox2;
    private Button button;
    private TextView register;
    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    checkBox=(CheckBox)findViewById(R.id.checkBox);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        button=(Button)findViewById(R.id.button);
        register=(TextView)findViewById(R.id.textView4);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });



}

}

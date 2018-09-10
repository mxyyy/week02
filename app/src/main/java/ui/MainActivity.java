package ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.week2.R;

import di.IContract;
import di.PresenterImp;

public class MainActivity extends AppCompatActivity implements IContract.iview {

    private EditText et_password;
    private EditText et_username;
    private Button btn_login;
    private Button btn_regist;
    private PresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_password = findViewById(R.id.et_password);
        et_username = findViewById(R.id.et_username);
        btn_login = findViewById(R.id.btn_login);
        btn_regist = findViewById(R.id.btn_regist);
        presenterImp = new PresenterImp();
        presenterImp.attachView(this);
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                presenterImp.requestInfo1(username,password);
            }
        });
    }

    @Override
    public void Show(final String message) {
        //强制切回主线程
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                if (message.equals("登录成功")){

                    Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}

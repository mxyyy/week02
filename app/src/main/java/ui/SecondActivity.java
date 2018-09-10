package ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.week2.R;

import di.IContract;
import di.PresenterImp;

public class SecondActivity extends AppCompatActivity implements IContract.iview {

    private EditText et_name;
    private EditText et_pwd;
    private Button regist;
    private PresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
        regist = findViewById(R.id.regist);
        presenterImp = new PresenterImp();
        presenterImp.attachView(this);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String pwd = et_pwd.getText().toString();
                presenterImp.requestInfo(name,pwd);
            }
        });


    }

    @Override
    public void Show(final String message) {
        //强制切回主线程
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SecondActivity.this,message,Toast.LENGTH_SHORT).show();
                if (message.equals("注册成功")){

                    /*Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);*/
                    finish();
                }
            }
        });
    }
}

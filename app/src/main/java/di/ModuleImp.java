package di;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Response;

public class ModuleImp implements IContract.imodule{

    private String path="https://www.zhaoapi.cn/user/reg";
    private String path1="https://www.zhaoapi.cn/user/login";



    @Override
    public void requestData(String registusername, String registpassword, final calllisten calllisten) {
        if (registusername.equals("") || registpassword.equals("")){
            calllisten.responmsg("用户名或密码不正确");
            return;
        }
        HttpUtils httpUtils = HttpUtils.getinstance();
        FormBody formBody=new FormBody.Builder()
                .add("msg",registusername)
                .add("code",registpassword)
                .build();
        httpUtils.postData(path, formBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //calllisten.responmsg(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("xxx", string);
                calllisten.responmsg("注册成功");
            }
        });



    }

    @Override
    public void requestData1(String name, String password, final calllisten calllisten) {
        HttpUtils httpUtils = HttpUtils.getinstance();
        FormBody formBody=new FormBody.Builder()
                .add("msg","")
                .add("code","")
                .build();
        httpUtils.postData(path, formBody, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                calllisten.responmsg(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                calllisten.responmsg("登陆成功");
            }
        });
    }
}

package air.chenmh.com.model;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.List;

import air.chenmh.com.bean.LoginBean;
import air.chenmh.com.url.ServerConstant;
import air.chenmh.com.util.PreferenceUtil;
/**
 * model请求网络
 * Created by 陈苗辉 on 2017/4/25.
 */
public class LoginImp implements LoginModel{
    private OkHttpClient client = new OkHttpClient();
//    public static String session;
    @Override
    public void Login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                FormEncodingBuilder builder = new FormEncodingBuilder();
                builder.add("accountName",username);
                builder.add("password",password);
                final Request request = new Request.Builder()
                        .url(ServerConstant.BASE_URI+"s/authen/authen?format=json")
                        .post(builder.build())
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        loginListener.LoginFailed("登录失败");
//                        Log.e("lll",request+"###########"+e);
                    }
                    @Override
                    public void onResponse(Response response) throws IOException {
                        if (response!=null){
                            Headers headers = response.headers();
                            String s = headers.get("Set-Cookie");
                            if (s==null){
                               return;
                            }
                            String session = s.substring(0, s.indexOf(";"));
//                            Log.e("lll",substring);
                            String result = response.body().string();
                            Gson gson = new Gson();
                            LoginBean login = gson.fromJson(result, LoginBean.class);
                            loginListener.LoginSuccess(login,session);
                        }else{
                            loginListener.LoginFailed("服务器数据为空...");
                        }
                    }
                });
            }
        }.start();
    }


}

package air.chenmh.com.model;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import air.chenmh.com.activity.LoginActivity;
import air.chenmh.com.bean.LoginBean;
import air.chenmh.com.bean.RealBean;
import air.chenmh.com.bean.WeatherThree;
import air.chenmh.com.url.ServerConstant;
import air.chenmh.com.util.PreferenceUtil;

/**
 * 实时数据的model
 * Created by 陈苗辉 on 2017/5/11.
 */
public class RealImp implements RealModel{
    private OkHttpClient client = new OkHttpClient();
    @Override
    public void load(final OnRealListener onRealListener) {

        new Thread(){
            @Override
            public void run() {
                super.run();
//                FormEncodingBuilder builder = new FormEncodingBuilder();
//                builder.add("","");
                Request request = new Request.Builder()
                        .addHeader("cookie", LoginActivity.cookie)//获取的cookie
                        .url(ServerConstant.BASE_URI+"s/standardSiteData/findCityLiveAQIByRegionCode?format=json")
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        onRealListener.RealFailed("请求异常...");
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        if (response!=null){
                            String result = response.body().string();
                            Gson gson = new Gson();
                            RealBean real = gson.fromJson(result, RealBean.class);
                            onRealListener.RealSuccess(real);
                        }else{
                            onRealListener.RealFailed("请求数据为空...");
                        }
                    }
                });
            }
        }.start();
        //第二个网络请求
        new Thread(){
            @Override
            public void run() {
                super.run();
                Request request = new Request.Builder()
                        .addHeader("cookie", LoginActivity.cookie)//获取的cookie
                        .url(ServerConstant.BASE_URI+"s/weather/findWeatherLiveByRegionCode?format=json")
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        onRealListener.RealFailed("请求异常...");
                    }
                    @Override
                    public void onResponse(Response response) throws IOException {
                        if (response!=null){
                            String result = response.body().string();
                            Gson gson = new Gson();
                            WeatherThree real = gson.fromJson(result, WeatherThree.class);
                            onRealListener.RealTopWeather(real);
                        }else{
                            onRealListener.RealFailed("请求数据为空...");
                        }
                    }
                });
            }
        }.start();
    }
}

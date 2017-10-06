package air.chenmh.com.view;

import air.chenmh.com.bean.LoginBean;
import air.chenmh.com.bean.RealBean;
import air.chenmh.com.bean.WeatherThree;

/**
 * 实时数据头的view
 * Created by 陈苗辉 on 2017/5/11.
 */
public interface RealView {

    //获取数据展示
    void loadReal(RealBean real);

    void loadWeather(WeatherThree r);
    //获取失败
    void showFailedError();
}

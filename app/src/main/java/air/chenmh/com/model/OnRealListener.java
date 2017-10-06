package air.chenmh.com.model;

import air.chenmh.com.bean.LoginBean;
import air.chenmh.com.bean.RealBean;
import air.chenmh.com.bean.WeatherThree;

/**
 * Created by 陈苗辉 on 2017/5/11.
 */
public interface OnRealListener {

    void RealSuccess(RealBean realBean);

    void RealTopWeather(WeatherThree bean);

    void RealFailed(String s);
}

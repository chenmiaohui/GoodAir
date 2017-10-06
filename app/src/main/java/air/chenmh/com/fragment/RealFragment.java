package air.chenmh.com.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import air.chenmh.com.R;
import air.chenmh.com.bean.LoginBean;
import air.chenmh.com.bean.RealBean;
import air.chenmh.com.bean.WeatherThree;
import air.chenmh.com.presenter.RealPresenter;
import air.chenmh.com.util.GlobalConsts;
import air.chenmh.com.util.TimeUtil;
import air.chenmh.com.view.RealView;
/**
 * 实时数据页面
 * Created by 陈苗辉 on 2017/5/11.
 */
public class RealFragment extends Fragment implements RealView{

    private RealPresenter presenter = new RealPresenter(this);
    private TextView mTime;
    private TextView mAreaName;
    private TextView mAqi;
    private LinearLayout mStateColor;
    private TextView mQuantity;
    private TextView mPollute;
    private TextView mTemperature;
    private TextView mHumidity;
    private TextView mWind;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_real, container, false);
        //time
        mTime = (TextView) view.findViewById(R.id.fbsj);
        mAreaName = (TextView) view.findViewById(R.id.main_area_name);
        mAqi = (TextView) view.findViewById(R.id.main_aqi);
        mStateColor = (LinearLayout) view.findViewById(R.id.statte_color);
        mQuantity = (TextView) view.findViewById(R.id.main_air_quantity);
        mPollute = (TextView) view.findViewById(R.id.main_major_pollute);
        mTemperature = (TextView) view.findViewById(R.id.top_temperature);
        mHumidity = (TextView) view.findViewById(R.id.top_humidity);
        mWind = (TextView) view.findViewById(R.id.top_wind);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.load();
    }

    @Override
    public void loadReal(RealBean real) {
        Log.e("YYYY","城市:"+real.getData().getRegionName()+"成功:"+real.getCode()+"AQI:"+real.getData().getAqi());
        if (real.getCode().equals("1111")){//请求成功
            //格式化时间
            mTime.setText(TimeUtil.getHourTime(real.getData().getMonitorTime()));
            //地址
            mAreaName.setText(real.getData().getRegionName());
            //AQI
            mAqi.setText(real.getData().getAqi()+"");
            //aqi等级颜色
            mStateColor.setBackgroundResource(GlobalConsts.getAqiStateDrawable(real.getData().getAqiLevel()+""));
            mQuantity.setText(real.getData().getAqiLevelType());
            mPollute.setText(real.getData().getPollutant());
            //6中污染物 数值、边框颜色、字体优良等级、字体颜色
        }else{
            //failed
            Toast.makeText(getActivity(),"失败",Toast.LENGTH_SHORT).show();
        }

    }
    //TopWeather 湿度  温度  风向
    @Override
    public void loadWeather(WeatherThree r) {

        if (r.getCode().equals("1111")){//请求成功
            mTemperature.setText(r.getData().getTemperature()+"℃");//温度
            mHumidity.setText(r.getData().getHumidity()+"%");//湿度
            if (r.getData().getWindDirect().equals("9999")){
                mWind.setText(""+r.getData().getWindPower());
            }else{
                mWind.setText(r.getData().getWindDirect()+r.getData().getWindPower());//风向，风力
            }
        }else{
        //失败
            Toast.makeText(getActivity(),"服务器解析失败...",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showFailedError() {
        Toast.makeText(getActivity(),"Failed...",Toast.LENGTH_SHORT).show();
    }
}

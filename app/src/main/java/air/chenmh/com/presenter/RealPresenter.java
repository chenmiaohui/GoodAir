package air.chenmh.com.presenter;
import android.os.Handler;
import air.chenmh.com.bean.LoginBean;
import air.chenmh.com.bean.RealBean;
import air.chenmh.com.bean.WeatherThree;
import air.chenmh.com.model.OnRealListener;
import air.chenmh.com.model.RealImp;
import air.chenmh.com.view.RealView;

/**
 * 实时数据的控制层Presenter
 * Created by 陈苗辉 on 2017/5/11.
 */
public class RealPresenter {

    private RealView realView;
    private RealImp realImp;
    private Handler handler = new Handler();
    public RealPresenter(RealView realView){
        this.realView = realView;
        realImp = new RealImp();
    }
    public void load(){
        realImp.load(new OnRealListener() {
            @Override
            public void RealSuccess(final RealBean realBean) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        realView.loadReal(realBean);
                    }
                });
            }
            //第二个网络请求
            @Override
            public void RealTopWeather(final WeatherThree bean) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        realView.loadWeather(bean);
                    }
                });
            }


            @Override
            public void RealFailed(String s) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        realView.showFailedError();
                    }
                });
            }
        });
    }

    public void loadTopWeather(){

    }
}

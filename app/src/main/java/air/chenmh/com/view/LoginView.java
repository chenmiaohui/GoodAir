package air.chenmh.com.view;

import air.chenmh.com.bean.LoginBean;
/**
 * 抽象类view
 * Created by 陈苗辉 on 2017/4/28.
 */
public interface LoginView {
    //用户名
    String getUsername();
    //密码
    String getPassword();
    //获取的数据展示
    void toHomeActivity(LoginBean login , String session);
    //加载失败
    void showFailedError();
}

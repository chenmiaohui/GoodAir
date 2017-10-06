package air.chenmh.com.model;

import air.chenmh.com.bean.LoginBean;
import air.chenmh.com.bean.LoginUser;

/**
 * Created by 陈苗辉 on 2017/4/25.
 */
public interface OnLoginListener {

    void LoginSuccess(LoginBean user,String s);

    void LoginFailed(String s);

}

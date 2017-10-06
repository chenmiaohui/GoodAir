package air.chenmh.com.presenter;

import android.os.Handler;

import air.chenmh.com.bean.LoginBean;
import air.chenmh.com.model.LoginImp;
import air.chenmh.com.model.OnLoginListener;
import air.chenmh.com.view.LoginView;

/**
 * model和view的沟通桥梁
 * Created by 陈苗辉 on 2017/4/28.
 */
public class LoginPresenter {
    private LoginView loginView;
    private LoginImp loginImp;
    private Handler handler = new Handler();
    public LoginPresenter(LoginView login){
        this.loginView = login;
        loginImp = new LoginImp();
    }
    public void Login(){
        loginImp.Login(loginView.getUsername(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void LoginSuccess(final LoginBean user , final String session) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toHomeActivity(user,session);
                    }
                });
            }

            @Override
            public void LoginFailed(String s) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError();
                    }
                });
            }
        });
    }
}

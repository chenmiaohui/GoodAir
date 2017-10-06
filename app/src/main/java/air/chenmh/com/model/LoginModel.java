package air.chenmh.com.model;

/**
 * Created by 陈苗辉 on 2017/4/25.
 */
public interface LoginModel {

    public void Login(String username,String password,OnLoginListener loginListener);
}

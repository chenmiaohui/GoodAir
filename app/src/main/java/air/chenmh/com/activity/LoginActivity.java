package air.chenmh.com.activity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import air.chenmh.com.R;
import air.chenmh.com.bean.LoginBean;
import air.chenmh.com.presenter.LoginPresenter;
import air.chenmh.com.util.PreferenceUtil;
import air.chenmh.com.view.LoginView;
/**
 * Created by 陈苗辉 on 2017/4/25.
 */
public class LoginActivity extends Activity implements LoginView{

    private LoginPresenter presenter = new LoginPresenter(this);
    private EditText username;
    private EditText password;
    private Button btn;
    private static final String PREFS_NAME = "ONE-PLATFORM";
    public static String cookie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.et_login_name);
        password = (EditText) findViewById(R.id.et_login_pwd);
        btn = (Button) findViewById(R.id.btn_login);
        btn.setOnClickListener(new OnBtnClickListener());
        //获取到保存到sp中的账号和密码
        username.setText(PreferenceUtil.getUsername(this));
        password.setText(PreferenceUtil.getPassword(this));
    }

    private void init() {
        final String user = username.getText().toString();
        String pass = password.getText().toString();
        if (user.length()==0){
            Toast.makeText(LoginActivity.this,"账号不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass.length()==0){
            Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        //保存登陆的账号和密码
        PreferenceUtil.saveUsername(LoginActivity.this,user);
        PreferenceUtil.savePassword(LoginActivity.this,pass);
    }

    private class OnBtnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            init();
            presenter.Login();//把本句话添加到onClick中
        }
    }

    @Override
    public String getUsername() {
        //用户名
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        //密码
        return password.getText().toString();
    }
    //从model中请求服务器得到的session
    @Override
    public void toHomeActivity(LoginBean login, String session) {
        String code = login.getCode();
//        Log.e("3333333",session+"   success   ");
//        PreferenceUtil.saveSession(session);//保存session到sp中，在其他地方添加到请求头中
        //保存
        SharedPreferences settings = this.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("session", session);
        //获取全局
        SharedPreferences getSession = this.getSharedPreferences(PREFS_NAME, 0);
        cookie = getSession.getString("session", "");
        editor.commit();
        if (code.equals("1111")){
            //登录成功
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }else{
            //登录失败
            Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showFailedError() {
        Toast.makeText(LoginActivity.this,"失败...",Toast.LENGTH_SHORT).show();
    }
}

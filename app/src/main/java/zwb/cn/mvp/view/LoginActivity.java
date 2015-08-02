package zwb.cn.mvp.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zwb.cn.app.BaseActivity;
import zwb.cn.mvp.view.iview.ILoginView;
import zwb.cn.mvp.view.presenter.LoginPresenter;
import zwb.cn.social.R;

/**
 * Created by zhangwb on 2015/7/31.
 */
public class LoginActivity extends BaseActivity implements ILoginView {

    //用户名
    @Bind(R.id.et_username)
    EditText et_username;
    //密码
    @Bind(R.id.et_userpwd)
    EditText et_userpwd;
    //登陆
    @Bind(R.id.bt_login)
    Button bt_login;
    //新用户
    @Bind(R.id.tv_new_user)
    TextView tv_new_user;

    private LoginPresenter loginPresenter;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter=new LoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return et_username.getText().toString().trim();
    }

    @Override
    public String getUserPwd() {
        return et_userpwd.getText().toString().trim();
    }

    @Override
    public void showDialog(String mes) {
          showSpotsDialog(mes);
    }

    @OnClick({R.id.bt_login,R.id.tv_new_user})
    public void click(View view){
        switch (view.getId()){
            case R.id.bt_login:
                loginPresenter.login(getUserName(),getUserPwd());
                break;
            case R.id.tv_new_user:
                loginPresenter.goToNewUserPage(this);
                break;
        }
    }

}

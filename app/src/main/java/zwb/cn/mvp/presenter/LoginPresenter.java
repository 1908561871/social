package zwb.cn.mvp.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import zwb.cn.config.NetCode;
import zwb.cn.mvp.view.LoginActivity;
import zwb.cn.mvp.model.imodel.ILoginMode;
import zwb.cn.mvp.view.iview.ILoginView;
import zwb.cn.mvp.model.LoginModel;
import zwb.cn.util.StringUtils;

/**
 * Created by Administrator on 2015/8/2.
 */
public class LoginPresenter {

    private LoginActivity loginView;
    private ILoginMode loginMode;

    private Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            loginView.hideSpotsDialog();
            switch (msg.arg1){
               case NetCode.LOGIN_SUCCESS:
                   goToMainPage(loginView);
                   break;
               case NetCode.LOGIN_FAIL:
                   loginView.showSnakeBar(msg.obj.toString());
                   break;
           }
        }
    };

    public LoginPresenter(ILoginView loginView) {
        this.loginView = (LoginActivity) loginView;
        loginMode=new LoginModel();
    }

    /**
     * 登录操作
     * @param name
     * @param pwd
     */
    public void login(String name,String pwd){
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)){
            return;
        }
        loginView.showDialog("正在登录...");
        loginMode.loginAction(name,pwd,handler);
    }

    /**
     * 跳转到注册新用户界面
     * @param context
     */
    public void goToNewUserPage(Context context){
        loginMode.goToNewUserPage(context);
    }


    /**
     * 跳转到注册新用户界面
     * @param context
     */
    public void goToMainPage(Context context){
        loginMode.goToNMainPage(context);
    }
}

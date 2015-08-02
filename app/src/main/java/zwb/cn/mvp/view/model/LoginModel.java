package zwb.cn.mvp.view.model;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import zwb.cn.im.IMCoreHelper;
import zwb.cn.mvp.view.MainActivity;
import zwb.cn.mvp.view.ResignActivity;
import zwb.cn.mvp.view.imodel.ILoginMode;

public class LoginModel implements ILoginMode {

    @Override
    public void loginAction(String name, String pwd, Handler handler) {
        IMCoreHelper.login(name,pwd,handler);
    }

    @Override
    public void goToNewUserPage(Context context) {
        Intent intent=new Intent(context, ResignActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void goToNMainPage(Context context) {
        Intent intent=new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}

package zwb.cn.mvp.model.imodel;

import android.content.Context;
import android.os.Handler;

/**
 * Created by Administrator on 2015/8/2.
 */
 public interface ILoginMode {

    void loginAction(String name,String pwd,Handler handler);
    void goToNewUserPage(Context context);
    void goToNMainPage(Context context);
}

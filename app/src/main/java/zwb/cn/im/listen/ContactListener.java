package zwb.cn.im.listen;

import com.easemob.chat.EMContactListener;

import java.util.List;

import zwb.cn.exception.CrashApplication;
import zwb.cn.util.Logger;
import zwb.cn.util.ToastUtils;

/**监听联系人变化
 * Created by zhangweibo on 2015/8/3.
 */
public class ContactListener implements EMContactListener {

    public static  String TAG="ContactListener";
    @Override
    public void onContactAdded(List<String> list) {
        Logger.e(TAG,"onContactAdded");
    }

    @Override
    public void onContactDeleted(List<String> list) {
    //被删除
        Logger.e(TAG,"onContactDeleted");

    }

    @Override
    public void onContactInvited(String s, String s1) {
    //收到好友邀请
        Logger.e(TAG,"onContactInvited");
    }

    @Override
    public void onContactAgreed(String s) {
   //好友请求被同意
        Logger.e(TAG,"onContactAgreed");

    }

    @Override
    public void onContactRefused(String s) {
   //好友请求被拒绝
        Logger.e(TAG,"onContactRefused");
    }
}

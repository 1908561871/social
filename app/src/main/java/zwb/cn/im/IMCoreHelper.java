package zwb.cn.im;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.easemob.EMCallBack;
import com.easemob.EMError;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;
import com.easemob.exceptions.EaseMobException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import zwb.cn.config.NetCode;
import zwb.cn.exception.CrashApplication;

/**
 * Created by zhangwb on 2015/7/31.
 */
public class IMCoreHelper {


    private static ExecutorService pool = Executors.newSingleThreadExecutor();

    /**
     * 注册
     * @param username
     * @param pwd
     */

    public static void register(final String username,final String pwd, final Handler handler){
        final Message msg=handler.obtainMessage();

        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    EMChatManager.getInstance().createAccountOnServer(username, pwd);
                    msg.obj="注册成功！";
                } catch (EaseMobException e) {
                    int errorCode=e.getErrorCode();
                    if(errorCode== EMError.NONETWORK_ERROR){
                        msg.obj="网络异常，请检查网络！";
                    }else if(errorCode==EMError.USER_ALREADY_EXISTS){
                        msg.obj="用户已存在！";
                    }else if(errorCode==EMError.UNAUTHORIZED){
                        msg.obj="注册失败，无权限！";
                    }else{
                        msg.obj="注册失败！";
                    }
                }
                handler.sendMessage(msg);
            }
        });

    }


    /**
     * 登陆
     * @param userName
     * @param pwd
     * @param handler
     */

    public static void login(final String userName, final String pwd, final Handler handler){
        final Message msg=handler.obtainMessage();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                EMChatManager.getInstance().login(userName, pwd, new EMCallBack() {//回调
                    @Override
                    public void onSuccess() {
                        EMGroupManager.getInstance().loadAllGroups();
                        EMChatManager.getInstance().loadAllConversations();
                        msg.arg1= NetCode.LOGIN_SUCCESS;
                        msg.obj = "登录成功";
                        handler.sendMessage(msg);
                    }

                    @Override
                    public void onProgress(int progress, String status) {

                    }

                    @Override
                    public void onError(int code, String message) {
                        msg.arg1= NetCode.LOGIN_FAIL;
                        msg.obj = message;
                        handler.sendMessage(msg);
                    }
                });
            }
        });


    }


    /**
     * 退出登录
     * @param handler
     */
     public static void logout(Handler handler){

        pool.execute(new Runnable() {
            @Override
            public void run() {
                EMChatManager.getInstance().logout(new EMCallBack() {

                    @Override
                    public void onSuccess() {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onProgress(int progress, String status) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onError(int code, String message) {
                        // TODO Auto-generated method stub

                    }
                });

            }
        });


     }





}

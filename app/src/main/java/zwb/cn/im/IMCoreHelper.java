package zwb.cn.im;

import android.widget.Toast;

import com.easemob.EMError;
import com.easemob.chat.EMChatManager;
import com.easemob.exceptions.EaseMobException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import zwb.cn.exception.CrashApplication;

/**
 * Created by zhangwb on 2015/7/31.
 */
public class IMCoreHelper {


    private static ExecutorService pool = Executors. newSingleThreadExecutor();

    /**
     * 注册
     * @param username
     * @param pwd
     */

    public static void register(final String username,final String pwd){

        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    EMChatManager.getInstance().createAccountOnServer(username, pwd);
                } catch (EaseMobException e) {
                    int errorCode=e.getErrorCode();
                    if(errorCode== EMError.NONETWORK_ERROR){
                        Toast.makeText(CrashApplication.getInstance(), "网络异常，请检查网络！", Toast.LENGTH_SHORT).show();
                    }else if(errorCode==EMError.USER_ALREADY_EXISTS){
                        Toast.makeText(CrashApplication.getInstance(), "用户已存在！", Toast.LENGTH_SHORT).show();
                    }else if(errorCode==EMError.UNAUTHORIZED){
                        Toast.makeText(CrashApplication.getInstance(), "注册失败，无权限！", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(CrashApplication.getInstance(), "注册失败: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }





}

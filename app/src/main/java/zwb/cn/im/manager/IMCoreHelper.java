package zwb.cn.im.manager;

import android.content.Context;
import android.content.Intent;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.im.v2.AVIMClient;
import com.avos.avoscloud.im.v2.callback.AVIMClientCallback;

import zwb.cn.util.ToastUtils;

/**
 * Created by Administrator on 2015/7/30.
 */
public class IMCoreHelper {


    public static void login(String clientID,final Context context){

        AVIMClient imClient = AVIMClient.getInstance(clientID);
        imClient.open(new AVIMClientCallback(){
            @Override
            public void done(AVIMClient client, AVException e) {
                ToastUtils.show(context,"获取数据成功");
                if (null != e) {
                    // 出错了，可能是网络问题无法连接 LeanCloud 云端，请检查网络之后重试。
                    // 此时聊天服务不可用。
                    e.printStackTrace();
                } else {
                    // 成功登录，可以开始进行聊天了（假设为 MainActivity）。
                };
            }
        });


    }


}

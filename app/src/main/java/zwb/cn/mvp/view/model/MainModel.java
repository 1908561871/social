package zwb.cn.mvp.view.model;

import android.content.Context;
import android.content.IntentFilter;

import com.easemob.chat.EMChatManager;

import zwb.cn.im.recevier.NewMessageReceiver;
import zwb.cn.mvp.view.imodel.IMainModel;

/**
 * Created by zhangweibo on 2015/8/3.
 */
public class MainModel implements IMainModel{

    @Override
    public void resignNewMessReceiver(Context context) {
        NewMessageReceiver receiver=new NewMessageReceiver();
        IntentFilter intentFilter = new IntentFilter(EMChatManager.getInstance().getNewMessageBroadcastAction());
        intentFilter.setPriority(3);
        context.registerReceiver(receiver, intentFilter);
    }
}

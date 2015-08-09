package zwb.cn.im.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;

/**
 * Created by zhangweibo on 2015/8/3.
 */
public class DeliverMessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        abortBroadcast();

        String msgid = intent.getStringExtra("msgid");
        String from = intent.getStringExtra("from");
        EMConversation conversation = EMChatManager.getInstance().getConversation(from);
        if (conversation != null) {
            // 把message设为已读
            EMMessage msg = conversation.getMessage(msgid);
            if (msg != null) {
                msg.isDelivered = true;
            }
        }

    }
}

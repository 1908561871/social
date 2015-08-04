package zwb.cn.im;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;
import com.easemob.chat.ImageMessageBody;
import com.easemob.chat.LocationMessageBody;
import com.easemob.chat.NormalFileMessageBody;
import com.easemob.chat.TextMessageBody;
import com.easemob.chat.VoiceMessageBody;

import java.io.File;

/**
 * 消息处理对象，用来发送消息
 * Created by zhangweibo on 2015/8/4.
 */
public class IMMessageControl {

    /**
     * 发送文本和表情
     * @param conversationm
     * @param username
     * @param content
     */
    private void sendTextOrEmoijMes(EMConversation conversationm,String username,String content,EMMessage.ChatType type) {

        EMMessage message = EMMessage.createSendMessage(EMMessage.Type.TXT);
        message.setChatType(type);
    //设置消息body
        TextMessageBody txtBody = new TextMessageBody(content);
        message.addBody(txtBody);
    //设置接收人
        message.setReceipt(username);
    //把消息加入到此会话对象中
        conversationm.addMessage(message);
    //发送消息
        EMChatManager.getInstance().sendMessage(message, new EMCallBack() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onProgress(int i, String s) {

            }
        });

    }

    /**
     * 发送语音消息
     * @param conversation
     * @param username
     * @param filePath
     * @param second
     */

    public  void sendVoiceMes( EMConversation conversation,String username,String filePath,int second,EMMessage.ChatType type){

        EMMessage message = EMMessage.createSendMessage(EMMessage.Type.VOICE);
        message.setChatType(type);

        File file=new File(filePath);
        VoiceMessageBody body = new VoiceMessageBody(file, second);
        message.addBody(body);
        message.setReceipt(username);
        conversation.addMessage(message);
        EMChatManager.getInstance().sendMessage(message, new EMCallBack(){
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }

    /**
     * 发送图片信息
     * @param conversation
     * @param username
     * @param filePath
     */

    public void sendImageMes( EMConversation conversation,String username,String filePath,EMMessage.ChatType type){
        EMMessage message = EMMessage.createSendMessage(EMMessage.Type.IMAGE);
        message.setChatType(type);
        ImageMessageBody body = new ImageMessageBody(new File(filePath));
// 默认超过100k的图片会压缩后发给对方，可以设置成发送原图
// body.setSendOriginalImage(true);
        message.addBody(body);
        message.setReceipt(username);
        conversation.addMessage(message);
        EMChatManager.getInstance().sendMessage(message, new EMCallBack(){
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }

    /**
     * 发送地理位置
     * @param conversation
     * @param username
     */

    public  void sendLocationMes( EMConversation conversation,String username,EMMessage.ChatType type){

        EMMessage message = EMMessage.createSendMessage(EMMessage.Type.LOCATION);
        message.setChatType(type);

        LocationMessageBody locBody = new LocationMessageBody("", 0, 0);
        message.addBody(locBody);
        message.setReceipt(username);
        conversation.addMessage(message);
        EMChatManager.getInstance().sendMessage(message, new EMCallBack(){
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }


    public void sendFileMes(EMConversation conversation,String username,String filePath,EMMessage.ChatType type){

// 创建一个文件消息
        EMMessage message = EMMessage.createSendMessage(EMMessage.Type.FILE);
// 如果是群聊，设置chattype,默认是单聊
        message.setChatType(type);
//设置接收人的username
        message.setReceipt(username);
// add message body
        NormalFileMessageBody body = new NormalFileMessageBody(new File(filePath));
        message.addBody(body);
        conversation.addMessage(message);
        EMChatManager.getInstance().sendMessage(message, new EMCallBack(){
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }





}

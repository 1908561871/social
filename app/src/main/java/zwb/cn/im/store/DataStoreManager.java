package zwb.cn.im.store;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.SaveCallback;

import java.util.List;

import zwb.cn.config.DB_Constant;
import zwb.cn.entity.bean.UserInfo;

/**数据存储（保存到云端）
 * Created by zhangweibo on 2015/8/22.
 */
public class DataStoreManager {


    /**
     * 保存用户信息
     * @param userName
     */

    public static  void saveUser(String userName)
    {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setUserLogo("");
        userInfo.setUserDescrip("");
        userInfo.setUserNick("");
        userInfo.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                //TODO
                if (e==null){
                  //保存成功
                }else{
                  //保存失败
                }
            }
        });

    }

    /**
     * 通过用户名获取用户列表
     * @return
     */
    public static void obtainUserList(String useName,FindCallback<UserInfo> callback)
    {
        AVQuery<UserInfo> query = AVObject.getQuery(UserInfo.class);
        query.whereEqualTo(UserInfo.userName,useName);
        query.findInBackground(callback);
    }






}

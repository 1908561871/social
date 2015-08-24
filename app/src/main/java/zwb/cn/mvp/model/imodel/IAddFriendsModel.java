package zwb.cn.mvp.model.imodel;

import android.content.Context;

import com.avos.avoscloud.FindCallback;

import zwb.cn.entity.bean.UserInfo;

/**
 * Created by zhangweibo on 2015/8/23.
 */
public interface IAddFriendsModel {

    /**
     * 获取用户列表
     */
    public void obtainUserList(String useName,FindCallback<UserInfo> callback);

    /**
     * 好友基本信息界面
     */

    public void goToFriendsBaseInfoPager(Context context,UserInfo userInfo);


}

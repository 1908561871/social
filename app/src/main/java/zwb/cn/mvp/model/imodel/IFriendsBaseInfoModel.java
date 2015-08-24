package zwb.cn.mvp.model.imodel;

import android.content.Context;

import zwb.cn.entity.bean.UserInfo;

/**
 * Created by zhangweibo on 2015/8/24.
 */
public interface IFriendsBaseInfoModel {

    /**
     * 跳转到好友管理界面
     */
    public  void goToFriendsManagerPager(Context context,UserInfo userInfo);
}

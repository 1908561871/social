package zwb.cn.mvp.view.iview;

import java.util.List;

import zwb.cn.entity.bean.UserInfo;

/**
 * Created by zhangweibo on 2015/8/23.
 */
public interface IAddFriendsView {

    public String getSearchInfo();


    /**
     * 更新用户数据(获取数据成功)
     */
    public void updateUserInfoList(List<UserInfo> userInfos);


    /**
     * 获取用户数据失败
     */
    public void obtainUserInfoError();



}

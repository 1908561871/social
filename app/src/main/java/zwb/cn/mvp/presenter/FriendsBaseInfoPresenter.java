package zwb.cn.mvp.presenter;

import zwb.cn.entity.bean.UserInfo;
import zwb.cn.mvp.model.FriendsBaseInfoModel;
import zwb.cn.mvp.model.imodel.IFriendsBaseInfoModel;
import zwb.cn.mvp.view.FriendsBaseInfoActivity;
import zwb.cn.util.ToastUtils;

/**
 * Created by zhangweibo on 2015/8/24.
 */
public class FriendsBaseInfoPresenter {

    private IFriendsBaseInfoModel model;

    private FriendsBaseInfoActivity view;

    public FriendsBaseInfoPresenter(FriendsBaseInfoActivity view) {
        this.view = view;
        model=new FriendsBaseInfoModel();
    }



    public void goToFriendsManagerPager(UserInfo userInfo){
        model.goToFriendsManagerPager(view,userInfo);
    }

}

package zwb.cn.mvp.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.FindCallback;

import java.util.List;

import zwb.cn.entity.bean.UserInfo;
import zwb.cn.mvp.model.AddFriendsModel;
import zwb.cn.mvp.model.imodel.IAddFriendsModel;
import zwb.cn.mvp.view.AddFriendsActivity;
import zwb.cn.util.ToastUtils;

/**
 * Created by zhangweibo on 2015/8/23.
 */
public class AddFriendsPresenter {

    private AddFriendsActivity addFriendsActivity;

    private IAddFriendsModel addFriendsModel;

    public AddFriendsPresenter(AddFriendsActivity addFriendsActivity) {
        this.addFriendsActivity = addFriendsActivity;
        addFriendsModel=new AddFriendsModel();
    }

    /**
     * 获取用户信息
     */
    public void obtainUserInfoList(){

        String useName=addFriendsActivity.getSearchInfo();
        if (TextUtils.isEmpty(useName)){
            ToastUtils.show(addFriendsActivity,"用户账号不能为空");
            return;
        }
        addFriendsActivity.showLoadToast();
        addFriendsModel.obtainUserList(useName, new FindCallback<UserInfo>() {
            @Override
            public void done(List<UserInfo> list, AVException e) {
                if (e==null){
                    addFriendsActivity.updateUserInfoList(list);
                }else{
                    addFriendsActivity.obtainUserInfoError();
                }
            }
        });

    }

    public void goToFriendsBaseInfoPager(UserInfo userInfo){
       addFriendsModel.goToFriendsBaseInfoPager(addFriendsActivity,userInfo);
    }



}

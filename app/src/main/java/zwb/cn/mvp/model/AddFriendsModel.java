package zwb.cn.mvp.model;

import android.content.Context;
import android.content.Intent;

import com.avos.avoscloud.FindCallback;

import zwb.cn.entity.bean.UserInfo;
import zwb.cn.im.store.DataStoreManager;
import zwb.cn.mvp.model.imodel.IAddFriendsModel;
import zwb.cn.mvp.view.FriendsBaseInfoActivity;
import zwb.cn.util.ToastUtils;

/**
 * Created by zhangweibo on 2015/8/23.
 */
public class AddFriendsModel implements IAddFriendsModel{


    @Override
    public void obtainUserList(String useName, FindCallback<UserInfo> callback) {
        DataStoreManager.obtainUserList(useName,callback);
    }

    @Override
    public void goToFriendsBaseInfoPager(Context context, UserInfo userInfo) {
        userInfo.toString();
        Intent intent= new Intent(context, FriendsBaseInfoActivity.class);
        intent.putExtra("userInfo",userInfo);
        context.startActivity(intent);
    }
}

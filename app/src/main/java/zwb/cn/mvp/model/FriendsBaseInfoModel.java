package zwb.cn.mvp.model;

import android.content.Context;
import android.content.Intent;

import zwb.cn.entity.bean.UserInfo;
import zwb.cn.mvp.model.imodel.IFriendsBaseInfoModel;
import zwb.cn.mvp.view.FriendsManagerActivity;

/**
 * Created by zhangweibo on 2015/8/24.
 */
public class FriendsBaseInfoModel implements IFriendsBaseInfoModel{



    @Override
    public void goToFriendsManagerPager(Context context, UserInfo userInfo) {
        userInfo.toString();
        Intent intent= new Intent(context, FriendsManagerActivity.class);
        intent.putExtra("userInfo",userInfo);
        context.startActivity(intent);
    }
}

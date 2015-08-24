package zwb.cn.mvp.model;

import android.content.Context;
import android.content.Intent;

import zwb.cn.mvp.model.imodel.IMyFrendsMode;
import zwb.cn.mvp.view.AddFriendsActivity;
import zwb.cn.mvp.view.MyFriendsListActivity;

/**
 * Created by zhangweibo on 2015/8/23.
 */
public class MyFriendsMode implements IMyFrendsMode {


    @Override
    public void goToAddFriendsPager(Context context) {
       Intent intent=new Intent(context, AddFriendsActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void goToAddFriendsListPager(Context context) {
        Intent intent=new Intent(context, MyFriendsListActivity.class);
        context.startActivity(intent);
    }
}

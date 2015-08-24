package zwb.cn.mvp.presenter;

import zwb.cn.mvp.model.MyFriendsMode;
import zwb.cn.mvp.view.MyFriendsListActivity;
import zwb.cn.mvp.view.fragment.FriendsFragment;

/**
 * Created by zhangweibo on 2015/8/23.
 */
public class MyFriendsPresenter {

    private MyFriendsMode myFriendsMode;

    private FriendsFragment friendsFragment;

    public MyFriendsPresenter(FriendsFragment friendsFragment) {
        this.friendsFragment = friendsFragment;
        myFriendsMode=new MyFriendsMode();
    }

    public void goToAddFriendsPager(){
        myFriendsMode.goToAddFriendsPager(friendsFragment.getActivity());
    }

    public void goToMyFriendsListPager(){
        myFriendsMode.goToAddFriendsListPager(friendsFragment.getActivity());
    }




}

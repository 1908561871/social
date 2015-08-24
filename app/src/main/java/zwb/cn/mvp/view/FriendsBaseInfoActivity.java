package zwb.cn.mvp.view;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import zwb.cn.app.BaseActivity;
import zwb.cn.entity.bean.UserInfo;
import zwb.cn.mvp.presenter.FriendsBaseInfoPresenter;
import zwb.cn.social.R;
import zwb.cn.util.ToastUtils;

/**好友信息界面
 * Created by zhangweibo on 2015/8/24.
 */
public class FriendsBaseInfoActivity extends BaseActivity{

    private FriendsBaseInfoPresenter presenter;

    private UserInfo userInfo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_baseinfo);
        ButterKnife.bind(this);
        try{
            userInfo=getIntent().getParcelableExtra("userInfo");

        }catch (Exception e)
        {
            ToastUtils.show(this,e.toString());
        }
        presenter=new FriendsBaseInfoPresenter(this);
    }

    /**
     * 添加好友
     */

    @OnClick(R.id.bt_add_friends)
    public  void addFriend(){
        presenter.goToFriendsManagerPager(userInfo);
    }




}

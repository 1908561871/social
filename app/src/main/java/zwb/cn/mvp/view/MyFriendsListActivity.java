package zwb.cn.mvp.view;

import android.os.Bundle;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import zwb.cn.app.BaseActivity;
import zwb.cn.social.R;

/**我的好友列表
 * Created by zhangweibo on 2015/8/22.
 */
public class MyFriendsListActivity extends BaseActivity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfriends);
        ButterKnife.bind(this);
        showLoadingView(R.layout.activity_myfriends);
    }





}

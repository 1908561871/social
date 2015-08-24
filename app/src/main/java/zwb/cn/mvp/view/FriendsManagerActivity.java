package zwb.cn.mvp.view;

import android.os.Bundle;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zwb.cn.app.BaseActivity;
import zwb.cn.entity.bean.UserInfo;
import zwb.cn.mvp.presenter.FriendsManagerPresenter;
import zwb.cn.mvp.view.iview.IFriendsManagerView;
import zwb.cn.social.R;

/**好友管理
 * Created by zhangweibo on 2015/8/24.
 */
public class FriendsManagerActivity extends BaseActivity implements IFriendsManagerView{

    private UserInfo userInfo;
    //申请理由
    @Bind(R.id.et_reason)
    EditText et_reason;
    private FriendsManagerPresenter presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_manager);
        ButterKnife.bind(this);
        userInfo=getIntent().getParcelableExtra("userInfo");
        presenter=new FriendsManagerPresenter(this);
    }

    @Override
    public String getApplyForReason() {
        return et_reason.getText().toString().trim();
    }

    @Override
    public String getApplyForUserName() {
        return userInfo.getUserName();
    }

    @OnClick(R.id.bt_send_request)
    public  void sendRequest(){
        presenter.sendRequest();
    }

}

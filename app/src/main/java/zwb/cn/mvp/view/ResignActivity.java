package zwb.cn.mvp.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zwb.cn.app.BaseActivity;
import zwb.cn.mvp.view.iview.IResignView;
import zwb.cn.mvp.presenter.ResignPresenter;
import zwb.cn.social.R;

/**
 * Created by zhangwb on 2015/7/31.
 */
public class ResignActivity extends BaseActivity implements IResignView{

    @Bind(R.id.bt_register)
    Button bt_register;
    @Bind(R.id.et_username)
    EditText et_username;
    @Bind(R.id.et_userpwd)
    EditText et_userpwd;
    private ResignPresenter presenter;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            hideSpotsDialog();
            showSnakeBar(msg.obj.toString());
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resign);
        ButterKnife.bind(this);
        setHeadTitle("用戶注册", true, true);
        presenter=new ResignPresenter(this);
    }

    @Override
    public String getUserName() {
        return et_username.getText().toString().trim();
    }

    @Override
    public String getUserPwd() {
        return et_userpwd.getText().toString().trim();
    }

    @Override
    public void showDialog(String mes) {
        showSpotsDialog(mes);
    }


    @OnClick(R.id.bt_register)
    public void setBt_register(){
        presenter.resignAction(getUserName(),getUserPwd(),handler);
    }

}

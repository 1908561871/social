package zwb.cn.mvp.view;

import android.os.Bundle;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import zwb.cn.app.BaseActivity;
import zwb.cn.im.manager.IMCoreHelper;
import zwb.cn.social.R;
import zwb.cn.view.eidttext.MaterialEditText;


public class SplashActivity extends BaseActivity {
   @Bind(R.id.et_name)
    MaterialEditText et_name;
    @Bind(R.id.bt_login)
    Button bt_login;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_login)
    public void click(){
        IMCoreHelper.login(et_name.getText().toString(),this);

    }

}

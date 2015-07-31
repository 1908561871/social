package zwb.cn.mvp.view;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zwb.cn.app.BaseActivity;
import zwb.cn.mvp.view.receiver.NetChangeReceiver;
import zwb.cn.social.R;
import zwb.cn.view.eidttext.MaterialEditText;


public class SplashActivity extends BaseActivity {
   @Bind(R.id.et_name)
    MaterialEditText et_name;
    @Bind(R.id.bt_login)
    Button bt_login;
    private NetChangeReceiver receiver;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        registerReceiver();
    }

    @OnClick(R.id.bt_login)
    public void click(){

    }

    public void registerReceiver(){
        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver=new NetChangeReceiver();
        this.registerReceiver(receiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver!=null){
            unregisterReceiver(receiver);
        }
    }
}

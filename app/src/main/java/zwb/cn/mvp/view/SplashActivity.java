package zwb.cn.mvp.view;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;

import com.easemob.EMConnectionListener;
import com.easemob.EMError;
import com.easemob.chat.EMChatManager;

import zwb.cn.app.BaseActivity;
import zwb.cn.receiver.NetChangeReceiver;
import zwb.cn.social.R;
import zwb.cn.util.SAFUtils;


public class SplashActivity extends BaseActivity {
    private NetChangeReceiver receiver;
    private Handler handler=new Handler();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //获取网络状态
        obtainNetStatue();
        registerReceiver();
        RegisterAutoReConnectListener();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToMainActivity();
            }
        },3000);
    }

    public void registerReceiver(){
        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver=new NetChangeReceiver();
        this.registerReceiver(receiver, filter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver!=null){
            unregisterReceiver(receiver);
        }
    }


    public void goToMainActivity(){
        Intent intent =new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void RegisterAutoReConnectListener(){
       // 注册一个监听连接状态的listener
        EMChatManager.getInstance().addConnectionListener(new MyConnectionListener());
   }

    private class MyConnectionListener implements EMConnectionListener {
        @Override
        public void onConnected() {
            //已连接到服务器
        }
        @Override
        public void onDisconnected(final int error) {
            if(error == EMError.USER_REMOVED){
                // 显示帐号已经被移除
            }else if (error == EMError.CONNECTION_CONFLICT) {
                // 显示帐号在其他设备登陆
            } else {
                if (!SAFUtils.checkNetworkStatus(SplashActivity.this)){
                    //没网络
                }else{
                    //连接不上服务器
                }
        }
    }
}



}

package zwb.cn.mvp.view.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import zwb.cn.event.NetChangeEvent;
import zwb.cn.eventbus.EventBusManager;

public class NetChangeReceiver extends BroadcastReceiver {
    public NetChangeReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            EventBusManager.getInstance().post(new NetChangeEvent());
            ConnectivityManager  mConnectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
           NetworkInfo netInfo = mConnectivityManager.getActiveNetworkInfo();
            if(netInfo != null && netInfo.isAvailable()) {
                /////////////网络连接
                String name = netInfo.getTypeName();
                if(netInfo.getType()==ConnectivityManager.TYPE_WIFI){
                    /////WiFi网络
                }else if(netInfo.getType()==ConnectivityManager.TYPE_ETHERNET){
                    /////有线网络
                }else if(netInfo.getType()==ConnectivityManager.TYPE_MOBILE){
                    /////////3g网络
                }
            } else {
                ////////网络断开
              //  EventBusManager.getInstance().post(new NetChangeEvent());
            }
        }

    }

}


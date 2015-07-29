package zwb.cn.im.manager;

import android.content.Context;

import com.yuntongxun.ecsdk.ECDevice;
import com.yuntongxun.ecsdk.ECInitParams;

/**
 * Created by zhangwb on 2015/7/29.
 */
public class IMCoreManger {

    private ECInitParams initParams;

    public void init(Context context){

        if (!ECDevice.isInitialized()){

            ECDevice.initial(context,new ECDevice.InitListener() {
                @Override
                public void onInitialized() {

                }

                @Override
                public void onError(Exception e) {

                }
            });
        }

    }


}

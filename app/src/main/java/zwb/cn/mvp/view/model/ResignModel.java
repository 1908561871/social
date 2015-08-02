package zwb.cn.mvp.view.model;

import android.os.Handler;

import zwb.cn.im.IMCoreHelper;
import zwb.cn.mvp.view.imodel.IResignModel;

/**
 * Created by Administrator on 2015/8/1.
 * 注册模型
 */
public class ResignModel implements IResignModel{

    @Override
    public void resignAction(String name, String pwd,Handler handler) {
        IMCoreHelper.register(name,pwd,handler);
    }



}

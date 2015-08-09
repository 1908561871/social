package zwb.cn.mvp.model;

import android.os.Handler;

import zwb.cn.im.IMCoreHelper;
import zwb.cn.mvp.model.imodel.IResignModel;

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

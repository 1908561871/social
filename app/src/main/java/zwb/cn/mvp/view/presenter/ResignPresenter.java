package zwb.cn.mvp.view.presenter;

import android.os.Handler;

import zwb.cn.im.IMCoreHelper;
import zwb.cn.mvp.view.iview.IResignView;
import zwb.cn.mvp.view.model.ResignModel;
import zwb.cn.util.StringUtils;

/**
 * Created by Administrator on 2015/8/1.
 */
public class ResignPresenter {

    private ResignModel resignModel;
    private IResignView resignView;

    public ResignPresenter(IResignView resignView) {
        this.resignView = resignView;
        this.resignModel=new ResignModel();
    }


    public void resignAction(String name,String pwd,Handler handler){
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)){
            return;
        }
        resignView.showDialog("正在注册信息...");
        resignModel.resignAction(name,pwd,handler);
    }



}

package zwb.cn.mvp.view.presenter;

import android.content.Context;

import zwb.cn.mvp.view.imodel.IMainModel;
import zwb.cn.mvp.view.iview.IMainView;
import zwb.cn.mvp.view.model.MainModel;

/**
 * Created by zhangweibo on 2015/8/4.
 */
public class MainPresenter {

    private IMainView iMainView;
    private IMainModel iMainModel;

    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
        iMainModel=new MainModel();
    }


    public void resignNewMessReceiver(Context context){

        iMainModel.resignNewMessReceiver(context);
    }


}

package zwb.cn.mvp.presenter;

import android.content.Context;

import zwb.cn.mvp.model.imodel.IMainModel;
import zwb.cn.mvp.view.iview.IMainView;
import zwb.cn.mvp.model.MainModel;

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


    public void IMinit(Context context){

        iMainModel.IMinit(context);
    }


}

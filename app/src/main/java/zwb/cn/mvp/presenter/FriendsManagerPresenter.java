package zwb.cn.mvp.presenter;

import android.text.TextUtils;

import zwb.cn.mvp.model.FriendsManagerModel;
import zwb.cn.mvp.model.imodel.IFriendsManagerModel;
import zwb.cn.mvp.view.FriendsManagerActivity;
import zwb.cn.util.ToastUtils;

/**
 * Created by zhangweibo on 2015/8/24.
 */
public class FriendsManagerPresenter {
    private IFriendsManagerModel model;

    private FriendsManagerActivity view;

    public FriendsManagerPresenter(FriendsManagerActivity view) {
        this.view = view;
        model=new FriendsManagerModel();
    }


    public void sendRequest(){
        if (TextUtils.isEmpty(view.getApplyForReason())){
            ToastUtils.show(view,"备注不能为空");
            return ;
        }
        model.applyForRequest(view.getApplyForUserName(),view.getApplyForReason());

    }

}

package zwb.cn.mvp.view;

import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zwb.cn.adapter.FriendsBaseInfoAdapter;
import zwb.cn.app.BaseActivity;
import zwb.cn.entity.bean.UserInfo;
import zwb.cn.mvp.presenter.AddFriendsPresenter;
import zwb.cn.mvp.view.iview.IAddFriendsView;
import zwb.cn.social.R;

/**
 * Created by zhangweibo on 2015/8/23.
 */
public class AddFriendsActivity extends BaseActivity implements IAddFriendsView{

   //列表显示
   @Bind(R.id.lv_search)
    ListView lv_search;
    private FriendsBaseInfoAdapter adapter;
    //输入框
    @Bind(R.id.et_search_info)
    EditText et_search_info;
    //用户信息列表
    private List<UserInfo> userInfos;

    private AddFriendsPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfirends);
        ButterKnife.bind(this);
        presenter=new AddFriendsPresenter(this);
        init();
    }

    public void init(){
        userInfos=new ArrayList<UserInfo>();
        adapter=new FriendsBaseInfoAdapter(this,userInfos);
        lv_search.setAdapter(adapter);
        lv_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.goToFriendsBaseInfoPager(userInfos.get(i));
            }
        });
    }


    @Override
    public String getSearchInfo() {
        return et_search_info.getText().toString().trim();
    }

    @Override
    public void updateUserInfoList(List<UserInfo> userInfos) {
        showLoadToastSuccess();
        this.userInfos.clear();
        this.userInfos.addAll(userInfos);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void obtainUserInfoError() {
        showLoadToastError();
    }

    @OnClick(R.id.tv_search)
    public void search(){
        presenter.obtainUserInfoList();
    }



}

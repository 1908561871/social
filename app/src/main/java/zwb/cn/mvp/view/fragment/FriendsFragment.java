package zwb.cn.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import zwb.cn.app.BaseFragment;
import zwb.cn.mvp.presenter.MyFriendsPresenter;
import zwb.cn.mvp.view.MyFriendsListActivity;
import zwb.cn.social.R;

/**
 * Created by zhangweibo on 2015/8/8.
 */
public class FriendsFragment extends BaseFragment implements BGARefreshLayout.BGARefreshLayoutDelegate {

    private MyFriendsPresenter presenter;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_friends);
        initRefreshLayout();
        presenter=new MyFriendsPresenter(this);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
  /*      mRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(mApp, false));
  *//*      BGAMoocStyleRefreshViewHolder moocStyleRefreshViewHolder = new BGAMoocStyleRefreshViewHolder(mApp, true);
        moocStyleRefreshViewHolder.setUltimateColor(getResources().getColor(R.color.gray));
        moocStyleRefreshViewHolder.setOriginalBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.logo_icon));
//        moocStyleRefreshViewHolder.setLoadMoreBackgroundColorRes(R.color.custom_imoocstyle);
        moocStyleRefreshViewHolder.setSpringDistanceScale(0.2f);
//        moocStyleRefreshViewHolder.setRefreshViewBackgroundColorRes(R.color.custom_imoocstyle);
        mRefreshLayout.setRefreshViewHolder(moocStyleRefreshViewHolder);*//*
        //mRefreshLayout.setCustomHeaderView(DataEngine.getCustomHeaderView(mApp), true);
        lv_listview_data.setAdapter(adapter);*/
    }

    @Override
    protected void onUserVisible() {

    }


    private void initRefreshLayout() {
        // 为BGARefreshLayout设置代理
     //   mRefreshLayout.setDelegate(this);

    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return false;
    }

    @OnClick({R.id.rl_myfiends,R.id.rl_add_friends})
    public void click(View v){
        switch (v.getId())
        {
            case R.id.rl_myfiends:
                presenter.goToMyFriendsListPager();
                break;
            case R.id.rl_add_friends:
                presenter.goToAddFriendsPager();
                break;
        }

    }



}

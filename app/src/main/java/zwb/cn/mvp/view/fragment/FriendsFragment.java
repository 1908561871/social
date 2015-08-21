package zwb.cn.mvp.view.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListView;

import butterknife.Bind;
import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGAStickinessRefreshViewHolder;
import zwb.cn.adapter.FriendsGroupAdapter;
import zwb.cn.app.BaseFragment;
import zwb.cn.social.R;

/**
 * Created by zhangweibo on 2015/8/8.
 */
public class FriendsFragment extends BaseFragment implements BGARefreshLayout.BGARefreshLayoutDelegate {

    @Bind(R.id.rl_listview_refresh)
    BGARefreshLayout mRefreshLayout;
    @Bind(R.id.lv_listview_data)
    ListView lv_listview_data;
    private FriendsGroupAdapter adapter;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_friends);
        initRefreshLayout();
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mRefreshLayout.setRefreshViewHolder(new BGANormalRefreshViewHolder(mApp, false));
  /*      BGAMoocStyleRefreshViewHolder moocStyleRefreshViewHolder = new BGAMoocStyleRefreshViewHolder(mApp, true);
        moocStyleRefreshViewHolder.setUltimateColor(getResources().getColor(R.color.gray));
        moocStyleRefreshViewHolder.setOriginalBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.logo_icon));
//        moocStyleRefreshViewHolder.setLoadMoreBackgroundColorRes(R.color.custom_imoocstyle);
        moocStyleRefreshViewHolder.setSpringDistanceScale(0.2f);
//        moocStyleRefreshViewHolder.setRefreshViewBackgroundColorRes(R.color.custom_imoocstyle);
        mRefreshLayout.setRefreshViewHolder(moocStyleRefreshViewHolder);*/
        //mRefreshLayout.setCustomHeaderView(DataEngine.getCustomHeaderView(mApp), true);
        adapter=new FriendsGroupAdapter(getActivity());
        lv_listview_data.setAdapter(adapter);
    }

    @Override
    protected void onUserVisible() {

    }


    private void initRefreshLayout() {
        // 为BGARefreshLayout设置代理
        mRefreshLayout.setDelegate(this);

    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return false;
    }
}

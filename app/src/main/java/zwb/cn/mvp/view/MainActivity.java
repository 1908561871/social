package zwb.cn.mvp.view;

import android.content.res.ColorStateList;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.easemob.chat.EMChat;

import butterknife.Bind;
import butterknife.ButterKnife;
import zwb.cn.app.BaseActivity;
import zwb.cn.mvp.view.iview.IMainView;
import zwb.cn.mvp.view.presenter.MainPresenter;
import zwb.cn.social.R;

public class MainActivity extends BaseActivity implements IMainView {
    @Bind(R.id.navigation)
   NavigationView navigation;
    @Bind(R.id.fl_content)
    FrameLayout fl_content;
    @Bind(R.id.rg_group)
    RadioGroup rg_group;
    private MainPresenter mainPresenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter=new MainPresenter(this);
        mainPresenter.resignNewMessReceiver(this);
        EMChat.getInstance().setAppInited();
        navigation.setItemTextColor(ColorStateList.valueOf(R.color.gray));
    }
}

package zwb.cn.mvp.view;

import android.content.res.ColorStateList;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import zwb.cn.app.BaseActivity;
import zwb.cn.social.R;

public class MainActivity extends BaseActivity {
    @Bind(R.id.navigation)
   NavigationView navigation;
    @Bind(R.id.fl_content)
    FrameLayout fl_content;
    @Bind(R.id.rg_group)
    RadioGroup rg_group;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigation.setItemTextColor(ColorStateList.valueOf(R.color.gray));
    }
}

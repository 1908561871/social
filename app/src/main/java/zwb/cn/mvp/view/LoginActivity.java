package zwb.cn.mvp.view;

import android.os.Bundle;

import butterknife.ButterKnife;
import zwb.cn.app.BaseActivity;

/**
 * Created by zhangwb on 2015/7/31.
 */
public class LoginActivity extends BaseActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}

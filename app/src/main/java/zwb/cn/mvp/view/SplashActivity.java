package zwb.cn.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zwb.cn.demo.Demo;
import zwb.cn.social.R;


public class SplashActivity extends ActionBarActivity {

    @Bind(R.id.bt_action)
    Button bt_action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_action)
    public void click(){
        Intent intent =new Intent(this, Demo.class);
        startActivity(intent);

    }



}

package zwb.cn.mvp.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zwb.cn.social.R;
import zwb.cn.view.ProgressLayout;
import zwb.cn.view.matchview.MatchTextView;


public class SplashActivity extends ActionBarActivity {

    @Bind(R.id.bt_action)
    Button bt_action;
    @Bind(R.id.mMatchTextView)
    MatchTextView mMatchTextView;

    @Bind((R.id.progress))
    ProgressLayout progressLayout;
    private Handler mHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        progressLayout.setProgress(true);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressLayout.setProgress(false);
            }
        }, 3000);
    }

    @OnClick(R.id.bt_action)
    public void click(){

        /*Intent intent=new Intent(this,PullToRefreshActivity.class);
        startActivity(intent);*/

    }




}

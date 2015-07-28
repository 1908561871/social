package zwb.cn.mvp.view;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zwb.cn.demo.PullToRefreshActivity;
import zwb.cn.net.HttpRequestBody;
import zwb.cn.net.HttpRequestUrl;
import zwb.cn.net.HttpUtil;
import zwb.cn.social.R;
import zwb.cn.util.ToastUtils;
import zwb.cn.view.matchview.MatchTextView;


public class SplashActivity extends ActionBarActivity {

    @Bind(R.id.bt_action)
    Button bt_action;
    @Bind(R.id.mMatchTextView)
    MatchTextView mMatchTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bt_action)
    public void click(){

        /*Intent intent=new Intent(this,PullToRefreshActivity.class);
        startActivity(intent);*/
        String str=null;
        if (str.equals("")){

        }

    }





}

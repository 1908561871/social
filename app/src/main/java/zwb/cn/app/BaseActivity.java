/**
 * 
 */
package zwb.cn.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import dmax.dialog.SpotsDialog;
import zwb.cn.event.NetChangeEvent;
import zwb.cn.exception.CrashApplication;
import zwb.cn.social.R;
import zwb.cn.util.NetWorkUtils;
import zwb.cn.util.SAFUtils;
import zwb.cn.util.ToastUtils;
import zwb.cn.view.loadtoast.LoadToast;

/**
 * @author Tony Shen
 *
 */
public class BaseActivity extends Activity{

	public static CrashApplication app;
	public int networkType;
	public String networkName;
	public static boolean isNetAvailabe;
	private boolean isShowNet;
    protected Handler mHandler = new SafeHandler(this);
	private SpotsDialog spotsDialog;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app = (CrashApplication) this.getApplication();
		addActivityToManager(this);
		EventBus.getDefault().register(this);
	}
	
	protected  void addActivityToManager(Activity act) {
        if (!app.activityManager.contains(act)) {
        	 app.activityManager.add(act);
	    }
	}
	
	protected void closeAllActivities() {
		for (final Activity act : app.activityManager) {
			if (act != null) {
				act.finish();
			}
		}
	}
	
	protected  void delActivityFromManager(Activity act) {
        if (app.activityManager.contains(act)) {
        	app.activityManager.remove(act);
        }
	}
	
	/**
	 * 杩斿洖褰撳墠杩愯activity鐨勫悕绉?
	 * @return
	 */
	protected String getCurrentActivityName() {
		int size = app.activityManager.size();
		if (size > 0) {
			return app.activityManager.get(size-1).getClass().getName();
		}
		return null;
	}
	
	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}


	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		delActivityFromManager(this);
		EventBus.getDefault().unregister(this);
    }
	
	protected void toast(String message) {
		ToastUtils.show(this, message);
	}

	protected void toast(int resId) {
		ToastUtils.show(this, resId);
	}
	
	/**
	 * 闃叉鍐呴儴Handler绫诲紩璧峰唴瀛樻硠闇?
	 * @author Tony Shen
	 *
	 */
    public static class SafeHandler extends Handler{
	    private final WeakReference<Activity> mActivity;
	    public SafeHandler(Activity activity) {
	        mActivity = new WeakReference<Activity>(activity);
	    }
	    @Override
	    public void handleMessage(Message msg) {
	        if(mActivity.get() == null) {
	            return;
	        }
	    }
	}


    /**
     * 设置标题
     * @param titleName
     * @param isBack
     */
    public void setHeadTitle(String titleName,boolean isBack,boolean isShowNet){
        TextView title= (TextView) findViewById(R.id.tv_title);
        title.setText(titleName);
		if (isBack){
			ImageView iv_back= (ImageView) findViewById(R.id.iv_back);
			iv_back.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					finish();
				}
			});
		}
        this.isShowNet=isShowNet;
		if (isShowNet && !isNetAvailabe){
			findViewById(R.id.rl_set_net).setVisibility(View.VISIBLE);
			findViewById(R.id.rl_set_net).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//todo
				}
			});
		}
    }

	@Subscribe
  public void netChange(NetChangeEvent event){
		isNetAvailabe=event.isNetAvailable();
      if (isShowNet && !isNetAvailabe){
		  findViewById(R.id.rl_set_net).setVisibility(View.VISIBLE);
          findViewById(R.id.rl_set_net).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
				  //todo
              }
          });
      }else{
		  findViewById(R.id.rl_set_net).setVisibility(View.GONE);
	  }
  }

	/**
	 * 获取当前的网络状态
	 */
	public  void obtainNetStatue(){
		isNetAvailabe= SAFUtils.checkNetworkStatus(this);
	}


	public void showSnakeBar(String mes){
		SAFUtils.hideSoftInputFromWindow(this, getWindow().getDecorView());
		SpannableString msp=new SpannableString(mes);
		msp.setSpan(new ForegroundColorSpan(Color.WHITE), 0, mes.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  //设置前景色为白色
		Snackbar.make(getWindow().getDecorView(),msp,Snackbar.LENGTH_SHORT).show();
	}


	public  void showSpotsDialog(String mes){

		if (spotsDialog==null){
			spotsDialog=new SpotsDialog(this,mes);
		}
		if (!spotsDialog.isShowing())
		{
			spotsDialog.show();
		}
	}


	public void hideSpotsDialog(){
		spotsDialog.dismiss();

	}



}

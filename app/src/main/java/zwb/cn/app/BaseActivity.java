/**
 * 
 */
package zwb.cn.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

import zwb.cn.exception.CrashApplication;
import zwb.cn.util.ToastUtils;

/**
 * @author Tony Shen
 *
 */
public class BaseActivity extends Activity{

	public static CrashApplication app;
	public int networkType;
	public String networkName;
    protected Handler mHandler = new SafeHandler(this);
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		app = (CrashApplication) this.getApplication();
		addActivityToManager(this);
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

}

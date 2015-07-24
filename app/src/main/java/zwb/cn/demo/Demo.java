package zwb.cn.demo;

import android.app.DownloadManager;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zwb.cn.social.R;
import zwb.cn.util.DownloadManagerPro;
import zwb.cn.util.TimeUtils;

public class Demo extends ActionBarActivity {

    @Bind(R.id.bt_action)
    Button bt_action;
    @Bind(R.id.tv_load)
    TextView tv_load;
    DownloadManager downloadManager;
    private long  id;
    private DownloadManagerPro downloadManagerPro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
        downloadObserver = new DownloadChangeObserver();
        downloadManager= (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManagerPro=new DownloadManagerPro(downloadManager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @OnClick(R.id.bt_action)
    public void click(){
        int a=0;
        int b=3;
        initDownLoad();
    }

    public void initDownLoad(){
        DownloadManager.Request request=new  DownloadManager.Request(Uri.parse("http://dlsw.baidu.com/sw-search-sp/soft/3a/12350/QQ_V7.4.15197.0_setup.1436951158.exe"));
        getFile("zwb");
        request.setDestinationInExternalPublicDir("zwb", TimeUtils.getCurrentTimeInString()+".exe");
        id= downloadManager.enqueue(request);
    }


    public boolean getFile(String path){
        File file = Environment.getExternalStoragePublicDirectory(path);
        return (file.exists() && file.isDirectory()) ? true : file.mkdirs();
    }

    class DownloadChangeObserver extends ContentObserver {

        public DownloadChangeObserver(){
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            updateView();
        }

    }

    public void updateView() {
        int[] bytesAndStatus = downloadManagerPro.getBytesAndStatus(id);

        handler.sendMessage(handler.obtainMessage(0, bytesAndStatus[0], bytesAndStatus[1],
                bytesAndStatus[2]));
    }

    private DownloadChangeObserver downloadObserver;


    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            tv_load.setText("当前进度是："+msg.arg1);
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        /** observer download change **/
        getContentResolver().registerContentObserver(DownloadManagerPro.CONTENT_URI, true,
                downloadObserver);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getContentResolver().unregisterContentObserver(downloadObserver);
    }
}

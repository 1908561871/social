package zwb.cn.demo;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

import butterknife.Bind;
import butterknife.ButterKnife;
import zwb.cn.social.R;
import zwb.cn.util.TimeUtils;
import zwb.cn.util.ToastUtils;

public class PullToRefreshActivity extends ActionBarActivity {
    @Bind(R.id.ultimate_recycler_view)
    UltimateRecyclerView ultimate_recycler_view;
    private ArrayList<String> datas;
    private Handler handler=new Handler(){

    };
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh);
        setData();
        ButterKnife.bind(this);
        final LinearLayoutManager  linearLayoutManager = new LinearLayoutManager(this);
        ultimate_recycler_view.setHasFixedSize(false);
        ultimate_recycler_view.setLayoutManager(linearLayoutManager);
        adapter=new MyAdapter();
        ultimate_recycler_view.setAdapter(adapter);
        ultimate_recycler_view.enableLoadmore();
        ultimate_recycler_view.setOnLoadMoreListener(new UltimateRecyclerView.OnLoadMoreListener() {
            @Override
            public void loadMore(int i, int i1) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.insert(datas, TimeUtils.getCurrentTimeInString(), datas.size() );
                        ultimate_recycler_view.disableLoadmore();
                    }
                }, 2000);

            }
        });
        ultimate_recycler_view.setDefaultOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                     adapter.insert(datas, TimeUtils.getCurrentTimeInString(),0);
                        ultimate_recycler_view.setRefreshing(false);
                        linearLayoutManager.scrollToPosition(0);
                    }
                }, 2000);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pull_to_refresh, menu);
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




    public void setData(){
        datas=new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            datas.add("这是第"+i+"个位置");
        }
    }



    class MyAdapter extends UltimateViewAdapter<MyAdapter.ViewHolder>{


        @Override
        public ViewHolder getViewHolder(View view) {
            return new ViewHolder(view,false);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
            View view= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.demo_item, viewGroup,false);
            return  new ViewHolder(view,true);
        }

        @Override
        public int getAdapterItemCount() {
            return datas.size();
        }

        @Override
        public long generateHeaderId(int i) {
            return 0;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            if (position<datas.size()){
                holder.title.setText(datas.get(position));
            }

        }

        @Override
        public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup) {
            return null;
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int i) {


        }

        class ViewHolder extends UltimateRecyclerviewViewHolder{
            @Bind(R.id.tv_title)
            TextView title;
            public ViewHolder(View itemView ,boolean isItem) {
                super(itemView);
                if (isItem){
                    ButterKnife.bind(this,itemView);
                }
            }
        }

    }




}

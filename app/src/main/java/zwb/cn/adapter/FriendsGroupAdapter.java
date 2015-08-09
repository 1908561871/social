package zwb.cn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import butterknife.ButterKnife;
import zwb.cn.social.R;

/**
 * Created by zhangweibo on 2015/8/9.
 */
public class FriendsGroupAdapter  extends BaseAdapter{
    private Context context;

    public FriendsGroupAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view!=null){
            viewHolder= (ViewHolder) view.getTag();
        }else{
            view= LayoutInflater.from(context).inflate(R.layout.fragment_friends_item,null);
            viewHolder=new ViewHolder(view);
        }

        return view;
    }

    class ViewHolder{

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }

    }

}

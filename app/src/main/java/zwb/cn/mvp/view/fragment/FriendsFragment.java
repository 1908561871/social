package zwb.cn.mvp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import zwb.cn.social.R;

/**
 * Created by zhangweibo on 2015/8/8.
 */
public class FriendsFragment extends Fragment {

    private View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //防止重新加载view
        if (view!=null){
           ViewGroup parent= (ViewGroup) view.getParent();
           if (parent!=null){
               parent.removeView(view);
           }
        }else{
           view= inflater.inflate(R.layout.fragment_friends,null);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }




}

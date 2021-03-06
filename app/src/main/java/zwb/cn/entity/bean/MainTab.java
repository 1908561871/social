package zwb.cn.entity.bean;

import zwb.cn.mvp.view.fragment.DynamicFragment;
import zwb.cn.mvp.view.fragment.FriendsFragment;
import zwb.cn.mvp.view.fragment.HomeFragment;
import zwb.cn.mvp.view.fragment.MessageFragment;
import zwb.cn.mvp.view.fragment.MoreFragment;
import zwb.cn.social.R;

/**
 * Created by zhangweibo on 2015/8/8.
 */
public enum  MainTab {
    //首页;
    HOME(R.drawable.button_home,R.string.home,0,0, HomeFragment.class,R.drawable.button_home),
    //消息
    MESSAGE(R.drawable.button_mes,R.string.message,1,1, MessageFragment.class,R.drawable.button_mes),
    //好友
    FRIENDS(R.drawable.button_friedns,R.string.friends,2,2, FriendsFragment.class,R.drawable.button_friedns),
    //动态
    DYNAMIC(R.drawable.button_dynamic,R.string.dynamic,3,3, DynamicFragment.class,R.drawable.button_dynamic),
    //更多
    MORE(R.drawable.button_more,R.string.more,4,4, MoreFragment.class,R.drawable.button_more);

    //图标
    private int icon;
    //标题
    private int title;
    //索引
    private int index;
    //浮标
    private int  View;

    private int drawable;
    private Class<?> clz;

    MainTab(int icon, int title, int index, int view, Class<?> clz, int drawable) {
        this.icon = icon;
        this.title = title;
        this.index = index;
        View = view;
        this.drawable = drawable;
        this.clz = clz;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getView() {
        return View;
    }

    public void setView(int view) {
        View = view;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}

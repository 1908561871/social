package zwb.cn.mvp.model.imodel;

/**
 * Created by zhangweibo on 2015/8/24.
 */
public interface IFriendsManagerModel {


    /**
     * 申请好友请求
     * @param useName 用户名
     * @param reason  理由
     */
    public void applyForRequest(String useName,String reason);



}

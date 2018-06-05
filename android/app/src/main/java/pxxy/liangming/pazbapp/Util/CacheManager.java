package pxxy.liangming.pazbapp.Util;

/**
 * Created by lrx on 2018/6/5.
 */

public class CacheManager {
    public void saveUserCache(String userId, String psw) {
        SpUtil.putString("userId", userId);
        SpUtil.putString("psw", psw);
    }
    public boolean isLogin() {
        return SpUtil.getString("userId") != null;
    }
    public String getCacheUserId() {
        return SpUtil.getString("userId");
    }
}

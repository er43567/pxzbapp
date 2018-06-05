package pxxy.liangming.pazbapp.net;
import pxxy.liangming.pazbapp.Conf.Conf;

/**
 * Created by asus on 2018/3/22.
 */

public class NetAdapterLrx extends NetAdapter {

    public static String loadDemoDataUrl = Conf.URL + "/loadUserList";
    public static String loginUrl = Conf.URL + "/login";

    public static void loadDemoData(String userId, NetManager.INetCallback callback) {
        NetManager.visit(loadDemoDataUrl
                , new String[]{"user.userId"}
        , new String[]{userId}, callback);
    }

    public static void login(String userId, String psw, NetManager.INetCallback callback) {
        NetManager.visit(loginUrl
                , new String[]{"user.userId", "user.userPsw"}
                , new String[]{userId, psw}, callback);
    }

}

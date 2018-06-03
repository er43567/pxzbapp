package pxxy.liangming.pazbapp.net;
import pxxy.liangming.pazbapp.Conf.Conf;

/**
 * Created by asus on 2018/3/22.
 */

public class NetAdapterLrx extends NetAdapter {

    public static String loadDemoDataUrl = Conf.URL + "/loadUserList";

    public static void loadDemoData(String userId, NetManager.INetCallback callback) {
        NetManager.visit(loadDemoDataUrl, new String[]{"user.userId"}, new String[]{userId}, callback);
    }

}

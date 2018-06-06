package pxxy.liangming.pazbapp.net;
import pxxy.liangming.pazbapp.Conf.Conf;

/**
 * Created by asus on 2018/3/22.
 */

public class NetAdapterLrx extends NetAdapter {

    public static String loadDemoDataUrl = Conf.URL + "/loadUserList";
    public static String loginUrl = Conf.URL + "/login";
    public static String submitFhzbUrl = Conf.URL + "/submitFhzb";

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

    public static void submitFhzb(int sel0, int sel1, int sel2
            , int sel3, int sel4, int sel5, NetManager.INetCallback callback) {

        NetManager.visit(submitFhzbUrl, new String[]{"fhzb.qwtk","fhzb.fdbx","fhzb.bd"
                ,"fhzb.fdtk","fhzb.fbdp","fhzb.dzg"}
                ,new String[]{sel0+"",sel1+"",sel2+"",sel3+"",sel4+"",sel5+""}
                , callback);
    }
}

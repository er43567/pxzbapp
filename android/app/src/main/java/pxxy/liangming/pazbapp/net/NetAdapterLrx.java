package pxxy.liangming.pazbapp.net;
import pxxy.liangming.pazbapp.Conf.Conf;

/**
 * Created by asus on 2018/3/22.
 */

public class NetAdapterLrx extends NetAdapter {

    public static String loadDemoDataUrl = Conf.URL + "/loadUserList";
    public static String loginUrl = Conf.URL + "/login";
    public static String submitReportDataUrl = Conf.URL + "/submitReport";
    public static String loadReportDataUrl = Conf.URL + "/loadReport";

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

    public static void submitFhzb(String zhuangbeiName,String zhuangbeiType,Object datas, NetManager.INetCallback callback) {

        /**
         * 这里也是改成三个参数
         * Action里面的接口方法不能用GetSet
         */
        NetManager.visit(submitReportDataUrl, new String[]{"report.zhuangbeiName","report.zhuangbeiType","report.datas"}
                , new String[]{"XX类型", "","123"}
                , callback);
    }
    public static void loadFhzb(NetManager.INetCallback callback){
        NetManager.visit(loadReportDataUrl,
                new String[]{},new String[]{},callback);
    }



}


package pxxy.liangming.pazbapp.net;
import pxxy.liangming.pazbapp.Conf.Conf;

/**
 * Created by asus on 2018/3/22.
 */

public class NetAdapterLrx extends NetAdapter {

    public static String loadDemoDataUrl = Conf.URL + "/loadUserList";
    public static String loginUrl = Conf.URL + "/login";
    public static String submitReportDataUrl = Conf.URL + "/submitReport";
    public static String loadReportDataUrl=Conf.URL+"/loadReport";

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

        /**
         * 这里也是改成三个参数
         * ok 有返回值的应该也不能用get开头吧 再Action里面的接口方法不能用GetSet
         */
        NetManager.visit(submitFhzbUrl, new String[]{"report.zhuangbeiType"}
                ,new String[]{"XX类型",""}
                , callback);//goto bed
    }
/*    private static getFhzb(String result, NetManager.INetCallback callback){

//TODO
        return result;

    }*/
}

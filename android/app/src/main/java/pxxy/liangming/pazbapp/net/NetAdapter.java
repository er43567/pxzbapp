package pxxy.liangming.pazbapp.net;

import android.util.Log;

import pxxy.liangming.pazbapp.Conf.Conf;

/**
 * Created by asus on 2018/3/22.
 */

public class NetAdapter {
    public static String url_pages = Conf.URL + "/pages";

    public void loadDemoData(String param, NetManager.INetCallback callback) {
        NetManager.visit("", new String[]{}, new String[]{}, callback);
    }
}

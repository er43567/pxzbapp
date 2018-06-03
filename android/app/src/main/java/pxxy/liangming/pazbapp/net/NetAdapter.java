package pxxy.liangming.pazbapp.net;

import android.util.Log;

import pxxy.liangming.pazbapp.Conf.Conf;

/**
 * Created by lrx on 2018/3/22.
 */

public class NetAdapter {

    public static void loadDemoData(String param, NetManager.INetCallback callback) {
        NetManager.visit("", new String[]{}, new String[]{}, callback);
    }
}

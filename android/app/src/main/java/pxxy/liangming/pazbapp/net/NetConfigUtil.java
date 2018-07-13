package pxxy.liangming.pazbapp.net;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Liangming on 2018/7/13 0013.
 * Liangming 版权所有.
 * For project: android
 * In package: pxxy.liangming.pazbapp.net
 */

public  class NetConfigUtil {
    private static Properties urlProps;
    public static Properties getProperties(){
        Properties props = new Properties();
        try {
            InputStream in = NetConfigUtil.class.getResourceAsStream("/netconfig.properties");
            props.load(in);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        urlProps = props;
        return urlProps;
    }
}


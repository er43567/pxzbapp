package pxxy.liangming.pazbapp.Util;

/**
 * Created by Liangming on 2018/6/4 0004.
 * Liangming 版权所有.
 * For project: android
 * In package: pxxy.liangming.pazbapp.Util
 */

public class LsettingView {

 /*   自定义属性
                        方法说明
    属性 	            说明 	        类型
    leftText 	        左侧文字        	string
    leftIcon 	        左侧图标        	integer
    rightIcon 	        右侧图标        	integer
    textSize 	        左侧文字大小  	dimension
    textColor 	        左侧文字颜色  	color
    isShowUnderLine 	显示底部分割线 	boolean
    rightStyle 	        右侧图标风格 	    enum


    右侧图标风格

            iconShow 显示图标
            iconHide 隐藏图标
            iconCheck 显示复选框
            iconSwitch 显示切换开关*/

 /*引用：
 *
 * <com.leon.lib.settingview.LSettingItem
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/item_one"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    leon:leftIcon="@drawable/history"
    leon:leftText="我的消息"/>
    */

 /*添加单击事件：
  *
  *  LSettingItem mSettingItemOne = (LSettingItem) findViewById(R.id.item_one);
mSettingItemOne.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
        @Override
        public void click() {
            Toast.makeText(getApplicationContext(), "我的消息", Toast.LENGTH_SHORT).show();
        }
    });
    */

}

package com.zbms.carinfomanage.service;

import java.util.List;
import java.util.ResourceBundle;

import com.zbms.carinfomanage.vo.carInfoAndOtherInfo;

import util.PageVO;

public interface carService {
	static final String propertiesPath = ResourceBundle.getBundle("_path").getString("filePath");

	public void test();

	public String setcarAllInfo(Object InfoObject) throws Exception;

	public String updatecarAllInfo(Object InfoObject) throws Exception;

	public String deletecarInfo(Object InfoObject) throws Exception;

	public carInfoAndOtherInfo getcarOneInfo(Object InfoObject) throws Exception;

	public PageVO<carInfoAndOtherInfo> getcarAllInfo(String InfoName,String page) throws Exception;
}

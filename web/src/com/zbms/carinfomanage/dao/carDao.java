package com.zbms.carinfomanage.dao;

import java.util.List;

import com.zbms.carinfomanage.vo.carInfoAndOtherInfo;

public interface carDao {

	public void test();

	public boolean setInfo(Object InfoObject);

	public boolean updateInfo(Object InfoObject);

	public Object getInfoById(String tableName, String idName, String idValue);

	public boolean deleteInfo(Object infoById);

	public carInfoAndOtherInfo getcarOneInfo(String tableName, String iDName, String iDValue,
			String carIdValue);

	public List<carInfoAndOtherInfo> getcarAllInfo(String tableName);

}

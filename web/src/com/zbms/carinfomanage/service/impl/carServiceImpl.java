package com.zbms.carinfomanage.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import com.zbms.all.domain.carAward;
import com.zbms.carinfomanage.dao.carDao;
import com.zbms.carinfomanage.service.carService;
import com.zbms.carinfomanage.vo.carInfoAndOtherInfo;

import util.PageVO;
import util.TimeUtil;
import util.uuid;

public class carServiceImpl implements carService {
	private carDao carDao;

	public void setcarDao(carDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public String setcarAllInfo(Object InfoObject) throws Exception {
		Class<? extends Object> infoClass = InfoObject.getClass();
		// 获取ID并赋值
		Field InfoId = infoClass.getDeclaredFields()[0];
		InfoId.setAccessible(true);
		InfoId.set(InfoObject, uuid.getUuid());

		// 获取日期并赋值
		Field time = infoClass.getDeclaredField("alterTime");
		time.setAccessible(true);
		time.set(InfoObject, TimeUtil.getStringDay());

		return carDao.setInfo(InfoObject) ? "success" : "error";
	}

	@Override
	public String updatecarAllInfo(Object InfoObject) throws Exception {
		/*
		 * Field[] fields = infoClass.getDeclaredFields(); Field id = fields[0];
		 * id.setAccessible(true); String infoId = (String) id.get(infoClass);
		 */
		return carDao.updateInfo(InfoObject) ? "success" : "error";
	}

	@Override
	public String deletecarInfo(Object InfoObject) throws Exception {
		Class<? extends Object> infoClass = InfoObject.getClass();
		// 获取ID并赋值
		Field InfoId = infoClass.getDeclaredFields()[0];
		InfoId.setAccessible(true);
		String idName = InfoId.getName();
		String idValue = (String) InfoId.get(InfoObject);
		String tableName = infoClass.getName();
		return carDao.deleteInfo(carDao.getInfoById(tableName, idName, idValue)) ? "success" : "error";
	}

	@Override
	public carInfoAndOtherInfo getcarOneInfo(Object InfoObject) throws Exception {
		Class<? extends Object> infoClass = InfoObject.getClass();

		// 学生id
		Field carId = infoClass.getDeclaredField("carId");
		carId.setAccessible(true);
		String carIdValue = (String) carId.get(InfoObject);

		// 信息ID
		Field infoID = infoClass.getDeclaredFields()[0];
		infoID.setAccessible(true);

		// ID名，值
		String IDName = infoID.getName();
		String IDValue = (String) infoID.get(InfoObject);
		// 表名
		String tableName = infoClass.getName();
		return carDao.getcarOneInfo(tableName, IDName, IDValue, carIdValue);
	}

	@Override
	public PageVO<carInfoAndOtherInfo> getcarAllInfo(String InfoName, String page) throws Exception {
		// 每页记录数
		int pageSize = 10;
		// 页数
		int pageIndex = Integer.parseInt(page);
		// 查询长度
		int toindex = pageSize;
		List<carInfoAndOtherInfo> list = carDao.getcarAllInfo(InfoName);
		// 总记录数
		int totalSize = list.size();
		// 当所要显示的最大值大于记录数最大值时，每页记录设置为不超过记录数值
		if (pageIndex * pageSize > totalSize) {
			toindex = totalSize - (pageIndex - 1) * pageSize;
		}
		// 设置VO内参数页码，每页记录数，总记录数
		PageVO<carInfoAndOtherInfo> pageVO = new PageVO<carInfoAndOtherInfo>(pageIndex, pageSize, totalSize);
		pageVO.setObjDatas(list.subList((pageIndex - 1) * pageSize, (pageIndex - 1) * pageSize + toindex));
		return pageVO;
	}

	@Override
	public void test() {
		System.out.println("service");
		System.out.println(carAward.class);
		carDao.test();
	}

}

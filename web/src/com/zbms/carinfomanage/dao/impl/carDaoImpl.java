package com.zbms.carinfomanage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zbms.carinfomanage.dao.carDao;
import com.zbms.carinfomanage.vo.carInfoAndOtherInfo;

public class carDaoImpl implements carDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void test() {
		System.out.println("dao");
	}

	@Override
	public boolean setInfo(Object InfoObject) {
		try {
			getSession().save(InfoObject);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateInfo(Object InfoObject) {
		try {
			getSession().update(InfoObject);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Object getInfoById(String tableName, String idName, String idValue) {
		return getSession().createQuery("from " + tableName + " where " + idName + " = ?").setString(0, idValue)
				.uniqueResult();
	}

	@Override
	public boolean deleteInfo(Object obj) {
		try {
			getSession().delete(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public carInfoAndOtherInfo getcarOneInfo(String tableName, String iDName, String iDValue,
			String carIdValue) {
		String hql = "select new com.zbms.carinfomanage.vo.carInfoAndOtherInfo(t,u) from " + tableName
				+ " t,carInfo u where u.carId='" + carIdValue + "' and t." + iDName + " = '" + iDValue
				+ "'";
		System.out.println(hql);
		return (carInfoAndOtherInfo) getSession().createQuery(hql).uniqueResult();
		/*
		 * return (carInfoAndOtherInfo)
		 * getSession().createCriteria(hql).setString(1, iDName).setString(2,
		 * iDValue) .uniqueResult();
		 */
	}

	@Override
	public List<carInfoAndOtherInfo> getcarAllInfo(String tableName) {
		String hql = "";
		if (!"carClass".equals(tableName)) {
			hql = "select new com.zbms.carinfomanage.vo.carInfoAndOtherInfo(t,u) from " + tableName
					+ " t,carInfo u where t.carId=u.carId";

		} else {
			hql = " from " + tableName;
		}
		return getSession().createQuery(hql).list();
	}
}

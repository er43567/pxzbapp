package com.zbms.system.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zbms.all.domain.Introduction;
import com.zbms.all.domain.Role;
import com.zbms.all.domain.User;
import com.zbms.system.dao.SystemDao;
import com.zbms.system.vo.DepartmentAndUserList;

public class SystemDaoImpl implements SystemDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public User getUserByUser_id(String user_id) {
		String hql = "from User where userId = '" + user_id + "'";
		return (User) getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public Role getUserRoleByRoleId(String roleId) {
		String hql = "from Role where roleId ='" + roleId + "'";
		return (Role) getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public User saveUser(User user) {
		try {
			getSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User updateUser(User user) {
		try {
			getSession().merge(user);
			getSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Introduction> getIntroduction(String departmentId) {
		String hql = "from Introduction where Introduction_department ='" + departmentId
				+ "' order by introductionRanking";
		return getSession().createQuery(hql).list();
	}

	@Override
	public List<User> getAllAdminUser() {
		String hql = "from User where roleId='20'";
		return getSession().createQuery(hql).list();
	}

	@Override
	public List<Map<String, String>> getDepartment() {
		String hql = "select new map(d.departmentId,d.departmentName) from Department d";
		return (List<Map<String, String>>) getSession().createQuery(hql).list();
	}

	@Override
	public String deleteUser(User user) {
		try {
			getSession().delete(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	@Override
	public List<DepartmentAndUserList> getTheDepartmentWithTheCollege() {
		String hql = "select new com.zbms.system.vo.DepartmentAndUserList(d) from Department d where d.departmentName like '%"
				+ "学院" + "'";
		return getSession().createQuery(hql).list();
	}

	@Override
	public List<User> getUserByDeparmentId(String departmentId) {
		String hql = "from User where departmentId ='" + departmentId + "'";
		return getSession().createQuery(hql).list();
	}
}

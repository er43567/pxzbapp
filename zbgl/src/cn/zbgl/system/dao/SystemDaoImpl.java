package cn.zbgl.system.dao;

import cn.zbgl.adapters.DaoAdapter;
import cn.zbgl.system.dao.SystemDao;
import cn.zbgl.system.vo.DepartmentAndUserList;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.zbgl.bean.Role;
import cn.zbgl.bean.User;

public class SystemDaoImpl extends DaoAdapter  implements SystemDao {

	public void testDao() {
		System.out.println("SystemDao层被调用，hibernateTemplate = " + hibernateTemplate);
	}
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public User getUserByUser_id(String user_id) {
		String hql = "from user_tb where userId = '" + user_id + "'";
		return (User) getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public Role getUserRoleByRoleId(String roleId) {
		String hql = "from role_tb where roleId ='" + roleId + "'";
		return (Role) getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public User updateUser(User loging_user) {
		System.out.println(loging_user);
		getSession().update(loging_user);
		return loging_user;
	}

	@Override
	public List<User> getAllAdminUser() {
		// TODO Auto-generated method stub
		System.out.println("方法为空");
		return null;
	}

	@Override
	public List<Map<String, String>> getDepartment() {
		// TODO Auto-generated method stub
		System.out.println("方法为空");
		return null;
	}

	@Override
	public String deleteUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("方法为空");
		return null;
	}

	@Override
	public List<DepartmentAndUserList> getTheDepartmentWithTheCollege() {
		// TODO Auto-generated method stub
		System.out.println("方法为空");
		return null;
	}

	@Override
	public List<User> getUserByDeparmentId(String departmentId) {
		// TODO Auto-generated method stub
		System.out.println("方法为空");
		return null;
	}


}

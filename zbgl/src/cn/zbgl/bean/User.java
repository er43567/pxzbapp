package cn.zbgl.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_tb")
public class User {
	@Id
	@GenericGenerator(name="userId", strategy="assigned")
	String userId;
	String userName;
	String userPsw;
	/**
	 * 数据库表设计要遵循 第一范式 ：  原子性，也就是不可再分性
	 */
	int roleRef;//指向角色
	String department;//指向部门 根据表的原子性，但是我们这里为了开发效率 就不加部门表了
	String substation;//分局 用这个把 ，多学点单词哦。
	String time;
	
	String roleType;//角色类型
	@Formula(value="(select tb.type from role_tb tb where tb.sid=roleRef)")
	//自动从角色表获取角色类型
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPsw() {
		return userPsw;
	}
	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}
	public int getRoleRef() {
		return roleRef;
	}
	public void setRoleRef(int roleRef) {
		this.roleRef = roleRef;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSubstation() {
		return substation;
	}
	public void setSubstation(String substation) {
		this.substation = substation;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userPsw=" + userPsw + ", roleRef=" + roleRef
				+ ", department=" + department + ", substation=" + substation
				+ ", time=" + time + "]";
	}
	
	
}

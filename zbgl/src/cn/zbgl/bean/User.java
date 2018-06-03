package cn.zbgl.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_tb")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String userId;
	private String userName;
	private String userPsw;
	
	private int roleId;
	private String userType;
	private int departmentId;
	private int policeId;
	private String alterTime;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPsw() {
		return userPsw;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}
	public int getRoleId() {
		return roleId;
	}
	public String getUserType() {
		return userType;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public int getPoliceId() {
		return policeId;
	}
	public String getAlterTime() {
		return alterTime;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public void setPoliceId(int policeId) {
		this.policeId = policeId;
	}
	public void setAlterTime(String alterTime) {
		this.alterTime = alterTime;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userPsw=" + userPsw + ", roleId=" + roleId + ", userType="
				+ userType + ", departmentId=" + departmentId + ", policeId="
				+ policeId + ", alterTime=" + alterTime + "]";
	}
	
}

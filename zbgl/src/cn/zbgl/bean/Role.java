package cn.zbgl.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role_tb")
public class Role implements java.io.Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	private int roleName;
	private int zbRank;
	private int carRank;
	
	public int getRoleId() {
		return roleId;
	}
	public int getRoleName() {
		return roleName;
	}
	public int getZbRank() {
		return zbRank;
	}
	public int getCarRank() {
		return carRank;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public void setRoleName(int roleName) {
		this.roleName = roleName;
	}
	public void setZbRank(int zbRank) {
		this.zbRank = zbRank;
	}
	public void setCarRank(int carRank) {
		this.carRank = carRank;
	}
	
}

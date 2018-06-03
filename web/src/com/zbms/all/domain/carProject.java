package com.zbms.all.domain;

/**
 * carProject entity. @author MyEclipse Persistence Tools
 */

public class carProject implements java.io.Serializable {

	// Fields

	private String projectId;
	private String projectName;
	private String carId;
	private String projectLeading;
	private String userId;
	private String createTime;

	// Constructors

	/** default constructor */
	public carProject() {
	}

	/** full constructor */
	public carProject(String projectId, String projectName, String carId, String projectLeading, String userId,
			String createTime) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.carId = carId;
		this.projectLeading = projectLeading;
		this.userId = userId;
		this.createTime = createTime;
	}

	// Property accessors

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getcarId() {
		return this.carId;
	}

	public void setcarId(String carId) {
		this.carId = carId;
	}

	public String getProjectLeading() {
		return this.projectLeading;
	}

	public void setProjectLeading(String projectLeading) {
		this.projectLeading = projectLeading;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getcreateTime() {
		return this.createTime;
	}

	public void setcreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "carProject [projectId=" + projectId + ", projectName=" + projectName + ", carId=" + carId
				+ ", projectLeading=" + projectLeading + ", userId=" + userId + ", createTime=" + createTime + "]";
	}

}
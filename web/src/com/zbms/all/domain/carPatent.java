package com.zbms.all.domain;

/**
 * carPatent entity. @author MyEclipse Persistence Tools
 */

public class carPatent implements java.io.Serializable {

	// Fields

	private String patentId;
	private String carId;
	private String awardName;
	private String awardClass;
	private String authorizationNo;
	private String time;
	private String firstPatent;
	private String createTime;

	// Constructors

	/** default constructor */
	public carPatent() {
	}

	/** full constructor */
	public carPatent(String patentId, String carId, String awardName, String awardClass, String authorizationNo,
			String time, String firstPatent, String createTime) {
		this.patentId = patentId;
		this.carId = carId;
		this.awardName = awardName;
		this.awardClass = awardClass;
		this.authorizationNo = authorizationNo;
		this.time = time;
		this.firstPatent = firstPatent;
		this.createTime = createTime;
	}

	// Property accessors

	public String getPatentId() {
		return this.patentId;
	}

	public void setPatentId(String patentId) {
		this.patentId = patentId;
	}

	public String getcarId() {
		return this.carId;
	}

	public void setcarId(String carId) {
		this.carId = carId;
	}

	public String getAwardName() {
		return this.awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardClass() {
		return this.awardClass;
	}

	public void setAwardClass(String awardClass) {
		this.awardClass = awardClass;
	}

	public String getAuthorizationNo() {
		return this.authorizationNo;
	}

	public void setAuthorizationNo(String authorizationNo) {
		this.authorizationNo = authorizationNo;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFirstPatent() {
		return this.firstPatent;
	}

	public void setFirstPatent(String firstPatent) {
		this.firstPatent = firstPatent;
	}

	public String getcreateTime() {
		return this.createTime;
	}

	public void setcreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "carPatent [patentId=" + patentId + ", carId=" + carId + ", awardName=" + awardName
				+ ", awardClass=" + awardClass + ", authorizationNo=" + authorizationNo + ", time=" + time
				+ ", firstPatent=" + firstPatent + ", createTime=" + createTime + "]";
	}

}
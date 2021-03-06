package com.zbms.all.domain;

/**
 * carAward entity. @author MyEclipse Persistence Tools
 */

public class carAward implements java.io.Serializable {

	// Fields

	private String awardId;
	private String carId;
	private String awardName;
	private String awardClass;
	private String authorizationNo;
	private String time;
	private String firstAward;
	private String createTime;

	// Constructors

	/** default constructor */
	public carAward() {
	}

	/** full constructor */
	public carAward(String awardId, String carId, String awardName, String awardClass, String authorizationNo,
			String time, String firstAward, String createTime) {
		this.awardId = awardId;
		this.carId = carId;
		this.awardName = awardName;
		this.awardClass = awardClass;
		this.authorizationNo = authorizationNo;
		this.time = time;
		this.firstAward = firstAward;
		this.createTime = createTime;
	}

	// Property accessors

	public String getAwardId() {
		return this.awardId;
	}

	public void setAwardId(String awardId) {
		this.awardId = awardId;
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

	public String getFirstAward() {
		return this.firstAward;
	}

	public void setFirstAward(String firstAward) {
		this.firstAward = firstAward;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "carAward [awardId=" + awardId + ", carId=" + carId + ", awardName=" + awardName
				+ ", awardClass=" + awardClass + ", authorizationNo=" + authorizationNo + ", time=" + time
				+ ", firstAward=" + firstAward + ", alterTime=" + createTime + "]";
	}

}
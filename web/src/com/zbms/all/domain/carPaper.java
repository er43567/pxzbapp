package com.zbms.all.domain;

import java.util.Date;

/**
 * carPaper entity. @author MyEclipse Persistence Tools
 */

public class carPaper implements java.io.Serializable {

	// Fields

	private String paperId;
	private String carId;
	private String periodical;
	private Date publishTime;
	private String includedSituation;
	private String createTime;

	// Constructors

	/** default constructor */
	public carPaper() {
	}

	/** full constructor */
	public carPaper(String paperId, String carId, String periodical, Date publishTime, String includedSituation,
			String createTime) {
		this.paperId = paperId;
		this.carId = carId;
		this.periodical = periodical;
		this.publishTime = publishTime;
		this.includedSituation = includedSituation;
		this.createTime = createTime;
	}

	// Property accessors

	public String getPaperId() {
		return this.paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getcarId() {
		return this.carId;
	}

	public void setcarId(String carId) {
		this.carId = carId;
	}

	public String getPeriodical() {
		return this.periodical;
	}

	public void setPeriodical(String periodical) {
		this.periodical = periodical;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getIncludedSituation() {
		return this.includedSituation;
	}

	public void setIncludedSituation(String includedSituation) {
		this.includedSituation = includedSituation;
	}

	public String getcreateTime() {
		return this.createTime;
	}

	public void setcreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "carPaper [paperId=" + paperId + ", carId=" + carId + ", periodical=" + periodical
				+ ", publishTime=" + publishTime + ", includedSituation=" + includedSituation + ", createTime="
				+ createTime + "]";
	}

}
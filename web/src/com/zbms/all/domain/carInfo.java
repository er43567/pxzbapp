package com.zbms.all.domain;

/**
 * carInfo entity. @author MyEclipse Persistence Tools
 */

public class carInfo implements java.io.Serializable {

	// Fields

	private String carId;
	private String carName;
	private String calendarYear;
	private Integer enrolmentYear;
	private String certificateType;
	private String certificateNo;
	private String birthYear;
	private String sex;
	private String nation;
	private String politicalStatus;
	private String carSource;
	private String carType;
	private String enrolmentType;
	private String classType;
	private String classNumber;
	private String className;
	private String inClassName;
	private Integer departmentId;
	private String zbTraining;
	private String deformed;
	private String changes;
	private String entranceRecord;
	private String enrolmentStyle;
	private String droppingReason;
	private String registeredType;
	private String degree;
	private String createTime;

	// Constructors

	/** default constructor */
	public carInfo() {
	}

	/** full constructor */
	public carInfo(String carId, String carName, String calendarYear, Integer enrolmentYear,
			String certificateType, String certificateNo, String birthYear, String sex, String nation,
			String politicalStatus, String carSource, String carType, String enrolmentType, String classType,
			String classNumber, String className, String inClassName, Integer departmentId, String zbTraining,
			String deformed, String changes, String entranceRecord, String enrolmentStyle, String droppingReason,
			String registeredType, String degree, String createTime) {
		this.carId = carId;
		this.carName = carName;
		this.calendarYear = calendarYear;
		this.enrolmentYear = enrolmentYear;
		this.certificateType = certificateType;
		this.certificateNo = certificateNo;
		this.birthYear = birthYear;
		this.sex = sex;
		this.nation = nation;
		this.politicalStatus = politicalStatus;
		this.carSource = carSource;
		this.carType = carType;
		this.enrolmentType = enrolmentType;
		this.classType = classType;
		this.classNumber = classNumber;
		this.className = className;
		this.inClassName = inClassName;
		this.departmentId = departmentId;
		this.zbTraining = zbTraining;
		this.deformed = deformed;
		this.changes = changes;
		this.entranceRecord = entranceRecord;
		this.enrolmentStyle = enrolmentStyle;
		this.droppingReason = droppingReason;
		this.registeredType = registeredType;
		this.degree = degree;
		this.createTime = createTime;
	}

	// Property accessors

	public String getcarId() {
		return this.carId;
	}

	public void setcarId(String carId) {
		this.carId = carId;
	}

	public String getcarName() {
		return this.carName;
	}

	public void setcarName(String carName) {
		this.carName = carName;
	}

	public String getCalendarYear() {
		return this.calendarYear;
	}

	public void setCalendarYear(String calendarYear) {
		this.calendarYear = calendarYear;
	}

	public Integer getEnrolmentYear() {
		return this.enrolmentYear;
	}

	public void setEnrolmentYear(Integer enrolmentYear) {
		this.enrolmentYear = enrolmentYear;
	}

	public String getCertificateType() {
		return this.certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNo() {
		return this.certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getBirthYear() {
		return this.birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getcarSource() {
		return this.carSource;
	}

	public void setcarSource(String carSource) {
		this.carSource = carSource;
	}

	public String getcarType() {
		return this.carType;
	}

	public void setcarType(String carType) {
		this.carType = carType;
	}

	public String getEnrolmentType() {
		return this.enrolmentType;
	}

	public void setEnrolmentType(String enrolmentType) {
		this.enrolmentType = enrolmentType;
	}

	public String getClassType() {
		return this.classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getClassNumber() {
		return this.classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getInClassName() {
		return this.inClassName;
	}

	public void setInClassName(String inClassName) {
		this.inClassName = inClassName;
	}

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getzbTraining() {
		return this.zbTraining;
	}

	public void setzbTraining(String zbTraining) {
		this.zbTraining = zbTraining;
	}

	public String getDeformed() {
		return this.deformed;
	}

	public void setDeformed(String deformed) {
		this.deformed = deformed;
	}

	public String getChanges() {
		return this.changes;
	}

	public void setChanges(String changes) {
		this.changes = changes;
	}

	public String getEntranceRecord() {
		return this.entranceRecord;
	}

	public void setEntranceRecord(String entranceRecord) {
		this.entranceRecord = entranceRecord;
	}

	public String getEnrolmentStyle() {
		return this.enrolmentStyle;
	}

	public void setEnrolmentStyle(String enrolmentStyle) {
		this.enrolmentStyle = enrolmentStyle;
	}

	public String getDroppingReason() {
		return this.droppingReason;
	}

	public void setDroppingReason(String droppingReason) {
		this.droppingReason = droppingReason;
	}

	public String getRegisteredType() {
		return this.registeredType;
	}

	public void setRegisteredType(String registeredType) {
		this.registeredType = registeredType;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getcreateTime() {
		return this.createTime;
	}

	public void setcreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "carInfo [carId=" + carId + ", carName=" + carName + ", calendarYear=" + calendarYear
				+ ", enrolmentYear=" + enrolmentYear + ", certificateType=" + certificateType + ", certificateNo="
				+ certificateNo + ", birthYear=" + birthYear + ", sex=" + sex + ", nation=" + nation
				+ ", politicalStatus=" + politicalStatus + ", carSource=" + carSource + ", carType="
				+ carType + ", enrolmentType=" + enrolmentType + ", classType=" + classType + ", classNumber="
				+ classNumber + ", className=" + className + ", inClassName=" + inClassName + ", departmentId="
				+ departmentId + ", zbTraining=" + zbTraining + ", deformed=" + deformed + ", changes="
				+ changes + ", entranceRecord=" + entranceRecord + ", enrolmentStyle=" + enrolmentStyle
				+ ", droppingReason=" + droppingReason + ", registeredType=" + registeredType + ", degree=" + degree
				+ ", createTime=" + createTime + "]";
	}

}
package cn.zbgl.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 每日检查表单
 */

/**
 * 报表
 */

@Entity
@Table(name="report_tb")
public class Report {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int sid;
	
	String userId;//谁检查的
	
	String zhuangbeiType;//装备所属分类
	
	String zhuangbeiName;//装备名字
	
	int data;//1 或 2
	
	String time;//通过每日的时间来查找当天的检查数据

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getZhuangbeiName() {
		return zhuangbeiName;
	}
	public String getZhuangbeiType() {
		return zhuangbeiType;
	}
	public void setZhuangbeiName(String zhuangbeiName) {
		this.zhuangbeiName = zhuangbeiName;
	}
	public void setZhuangbeiType(String zhuangbeiType) {
		this.zhuangbeiType = zhuangbeiType;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Report [sid=" + sid + ", userId=" + userId + ", zhuangbeiType=" + zhuangbeiType + ", zhuangbeiName="
				+ zhuangbeiName + ", data=" + data + ", time=" + time + "]";
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}

package cn.zbgl.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ZB_tb")
public class Zhuangbei implements java.io.Serializable  {
	
	public static final String Type_Fhzb = "Fhzb";
	public static final String Type_Djzb = "Djzb";
	//装备类型在装备实体里面定义
	/**
	Dljt
	Fhzb
	Fzzb
	Jsdj
	Jyzb
	Wqjx
	ZbInfo
	*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int sid;
	
	String belong;//所属分类
	
	String name;//装备名字

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

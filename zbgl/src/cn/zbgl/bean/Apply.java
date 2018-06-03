package cn.zbgl.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carrecord_tb")
public class Apply implements java.io.Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int recordId;
	int type;
	String returnType;
	String alterTime;
	public int getRecordId() {
		return recordId;
	}
	public int getType() {
		return type;
	}
	public String getReturnType() {
		return returnType;
	}
	public String getAlterTime() {
		return alterTime;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public void setAlterTime(String alterTime) {
		this.alterTime = alterTime;
	}
	
}

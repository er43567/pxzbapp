package cn.zbgl.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="police_tb")
public class Police implements java.io.Serializable  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int policeId;
	private String policeName;
	public int getPoliceId() {
		return policeId;
	}
	public String getPoliceName() {
		return policeName;
	}
	public void setPoliceId(int policeId) {
		this.policeId = policeId;
	}
	public void setPoliceName(String policeName) {
		this.policeName = policeName;
	}
	
}

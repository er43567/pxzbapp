package cn.zbgl.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fhzb_tb")
public class Fhzb {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int checkId;
	int qwtk;
	int fdbx;
	int bd;
	int fdtk;
	int fbdp;
	int dzg;
	String checktime;
	public int getCheckId() {
		return checkId;
	}
	public int getQwtk() {
		return qwtk;
	}
	public int getFdbx() {
		return fdbx;
	}
	public int getBd() {
		return bd;
	}
	public int getFdtk() {
		return fdtk;
	}
	public int getFbdp() {
		return fbdp;
	}
	public int getDzg() {
		return dzg;
	}
	public String getChecktime() {
		return checktime;
	}
	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}
	public void setQwtk(int qwtk) {
		this.qwtk = qwtk;
	}
	public void setFdbx(int fdbx) {
		this.fdbx = fdbx;
	}
	public void setBd(int bd) {
		this.bd = bd;
	}
	public void setFdtk(int fdtk) {
		this.fdtk = fdtk;
	}
	public void setFbdp(int fbdp) {
		this.fbdp = fbdp;
	}
	public void setDzg(int dzg) {
		this.dzg = dzg;
	}
	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}
	@Override
	public String toString() {
		return "Fhzb [checkId=" + checkId + ", qwtk=" + qwtk + ", fdbx=" + fdbx + ", bd=" + bd + ", fdtk=" + fdtk
				+ ", fbdp=" + fbdp + ", dzg=" + dzg + ", checktime=" + checktime + "]";
	}
}

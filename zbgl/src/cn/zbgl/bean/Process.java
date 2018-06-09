package cn.zbgl.bean;


/**
 * 流程表
 */

public class Process {
	int sid;
	
	int reportRef;//哪个检查（表）的流程
	
	int a;//第一个界面的是或者否    一级用户
	String aText;//第一个界面的说明    
	int b;//第二个界面的是或者否  二级用户审核
	String bText;//第二个界面的说明    
	int c;//第三个界面   一级用户申请 
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getReportRef() {
		return reportRef;
	}
	public void setReportRef(int reportRef) {
		this.reportRef = reportRef;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getaText() {
		return aText;
	}
	public void setaText(String aText) {
		this.aText = aText;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public String getbText() {
		return bText;
	}
	public void setbText(String bText) {
		this.bText = bText;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	
	
}

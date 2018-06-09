package test.lrx;

public class Ant {
	
	@MyInject
	String aaa;
	
	String bbb;
	
	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public String getBbb() {
		return bbb;
	}

	public void setBbb(String bbb) {
		this.bbb = bbb;
	}

	@Override
	public String toString() {
		return "Ant [aaa=" + aaa + ", bbb=" + bbb + "]";
	}
	
}

package cn.zbgl.lm.service;

public interface LmService {
	
	void CheckService();
	//一级民警自查提交数据
	void saveReports(String userId, String zhuangbeiType, String zhuangbeiName, String datas);
	//二级大队长获取一级当天自查
	String loadReports(String zhuangbeiType);
}

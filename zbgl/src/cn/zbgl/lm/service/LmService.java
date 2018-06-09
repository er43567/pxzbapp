package cn.zbgl.lm.service;

public interface LmService {
	
	void CheckService();

	void saveReports(String userId, String zhuangbeiType, String zhuangbeiName, String datas);
}

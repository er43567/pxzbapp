package cn.zbgl.lrx.service;

import cn.zbgl.bean.Fhzb;

public interface LrxService {
	
	void testService();

	int saveFhzb(String userId, Fhzb fhzb);
	
}

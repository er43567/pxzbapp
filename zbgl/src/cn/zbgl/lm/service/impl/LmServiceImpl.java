package cn.zbgl.lm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.zbgl.adapters.DaoAdapter;
import cn.zbgl.lm.dao.LmDao;
import cn.zbgl.lm.service.LmService;
import cn.zbgl.bean.Zhuangbei;


public class LmServiceImpl implements LmService {

	@Autowired
	LmDao dao;
	
	@Autowired
	DaoAdapter adapter;
	@Override
	public void CheckService() {
		System.out.println("LmService, lmDao = " + dao);
		dao.CheckDao();


	}

}

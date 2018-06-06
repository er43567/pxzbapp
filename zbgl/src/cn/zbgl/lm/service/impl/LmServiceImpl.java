package cn.zbgl.lm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zbgl.adapters.IDaoAdapter;
import cn.zbgl.lm.dao.LmDao;
import cn.zbgl.lm.dao.impl.LmDaoImpl;
import cn.zbgl.lm.service.LmService;

public class LmServiceImpl implements LmService {
	
	@Autowired
	LmDaoImpl dao;
	
	@Override
	public void CheckService() {
		System.out.println("LmService, lmDao = " + dao);
		dao.CheckDao();
	}

}

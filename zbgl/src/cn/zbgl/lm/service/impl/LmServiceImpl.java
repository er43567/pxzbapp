package cn.zbgl.lm.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zbgl.adapters.DaoAdapter;
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

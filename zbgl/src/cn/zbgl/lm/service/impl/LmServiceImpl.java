package cn.zbgl.lm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.zbgl.adapters.DaoAdapter;
import cn.zbgl.bean.Fhzb;
import cn.zbgl.lm.dao.LmDao;
import cn.zbgl.lm.service.LmService;


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

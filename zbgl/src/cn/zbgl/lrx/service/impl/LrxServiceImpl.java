package cn.zbgl.lrx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zbgl.adapters.DaoAdapter;
import cn.zbgl.bean.User;
import cn.zbgl.lrx.dao.LrxDao;
import cn.zbgl.lrx.service.LrxService;

@Service("lrxService")
@Transactional
public class LrxServiceImpl implements LrxService {
	
	@Autowired
	LrxDao dao;
	
	@Autowired
	DaoAdapter adapter;
	
	@Override
	public void testService() {
		System.out.println("Service层被调用, lrxDao = " + dao);
		dao.testDao();
		
		try {
			List<User> li = adapter.findByHql("from User", 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

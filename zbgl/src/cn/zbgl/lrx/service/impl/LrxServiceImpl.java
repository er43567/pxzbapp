package cn.zbgl.lrx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zbgl.adapters.DaoAdapter;
import cn.zbgl.adapters.IDaoAdapter;
import cn.zbgl.bean.Fhzb;
import cn.zbgl.bean.User;
import cn.zbgl.lrx.dao.LrxDao;
import cn.zbgl.lrx.dao.impl.LrxDaoImpl;
import cn.zbgl.lrx.service.LrxService;

@Service("lrxService")
@Transactional
public class LrxServiceImpl implements LrxService {
	
	@Autowired
	LrxDaoImpl dao;
	
	@Override
	public void testService() {
		System.out.println("Service层被调用, lrxDao = " + dao);
		
		try {
			List<User> li = dao.findByHql("from User", 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int saveFhzb(String userId, Fhzb fhzb) {
		try {
			System.out.println("saving..." + fhzb);
			return (Integer) dao.saveEntity(fhzb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}

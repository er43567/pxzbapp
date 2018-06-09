package cn.zbgl.lm.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zbgl.adapters.DaoAdapter;
import cn.zbgl.bean.Report;
import cn.zbgl.common.Tool;
import cn.zbgl.lm.dao.impl.LmDaoImpl;
import cn.zbgl.lm.service.LmService;

@Service("lmService")
@Transactional
public class LmServiceImpl implements LmService {
	
	@Autowired
	LmDaoImpl dao;
	
	@Override
	public void CheckService() {
		System.out.println("LmService, lmDao = " + dao);
		dao.CheckDao();
	}

	@Override
	public void saveReports(String userId, String zhuangbeiType,
			String zhuangbeiName, String datas) {
		Report r[] = new Report[datas.length()];
		for (int i = 0; i < r.length; i++) {
			r[i] = new Report();
			r[i].setUserId(userId);
			r[i].setData(new Integer(datas.charAt(i)-48));
			r[i].setZhuangbeiName(zhuangbeiName);
			r[i].setZhuangbeiType(zhuangbeiType);
			r[i].setTime(Tool.time());
			try {
				dao.saveEntity(r[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

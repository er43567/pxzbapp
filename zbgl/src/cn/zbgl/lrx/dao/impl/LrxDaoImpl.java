package cn.zbgl.lrx.dao.impl;

import org.springframework.stereotype.Repository;

import cn.zbgl.adapters.DaoAdapter;
import cn.zbgl.adapters.IDaoAdapter;
import cn.zbgl.lrx.dao.LrxDao;

@Repository("lrxDao")
public class LrxDaoImpl extends DaoAdapter implements LrxDao {
	
	@Override
	public void testDao() {
		System.out.println("Dao层被调用，hibernateTemplate = " + hibernateTemplate);
	}
	
}

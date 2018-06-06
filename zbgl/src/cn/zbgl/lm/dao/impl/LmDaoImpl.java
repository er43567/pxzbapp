package cn.zbgl.lm.dao.impl;

import org.springframework.stereotype.Repository;
import cn.zbgl.adapters.DaoAdapter;
import cn.zbgl.adapters.IDaoAdapter;
import cn.zbgl.lm.dao.LmDao;

@Repository("lmDao")
public class LmDaoImpl extends DaoAdapter implements LmDao {
	
	public void CheckDao(){
		System.out.println("CheckDao，hibernateTemplate = " + hibernateTemplate);
	}
}

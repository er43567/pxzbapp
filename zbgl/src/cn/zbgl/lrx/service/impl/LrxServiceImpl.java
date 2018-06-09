package cn.zbgl.lrx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zbgl.adapters.DaoAdapter;
import cn.zbgl.bean.User;
import cn.zbgl.lrx.dao.impl.LrxDaoImpl;
import cn.zbgl.lrx.service.LrxService;

@Service("lrxService")
@Transactional
public class LrxServiceImpl implements LrxService {
	@Autowired
	LrxDaoImpl dao;

}

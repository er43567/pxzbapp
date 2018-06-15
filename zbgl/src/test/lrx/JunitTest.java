package test.lrx;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zbgl.adapters.DaoAdapter;
import cn.zbgl.bean.Report;
import cn.zbgl.bean.User;
import cn.zbgl.bean.Zhuangbei;
import cn.zbgl.lm.dao.impl.LmDaoImpl;
import cn.zbgl.lm.service.LmService;
import cn.zbgl.lm.service.impl.LmServiceImpl;
import cn.zbgl.lrx.service.LrxService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class JunitTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	LmDaoImpl service;
	
	@Autowired
	
	@Test
	public void test1() {
		System.out.println("1kjhkhkjh");
	}
	
/*	@Test
	public void test2() {
		//service.saveReports("admin", Zhuangbei.Type_Fhzb, "xx装备", "1");


	}
	@Test
	public void test3() {
		//String li = service.loadReports();
		syprintln(li);
	}*/
	
/*	@Test
	public void test3(int length){
		length=1;
		System.out.println("\ntest方法结果:"+service.loadReports(length));
	}
	*/
}

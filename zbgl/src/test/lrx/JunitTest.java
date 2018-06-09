package test.lrx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zbgl.bean.User;
import cn.zbgl.bean.Zhuangbei;
import cn.zbgl.lm.service.LmService;
import cn.zbgl.lrx.service.LrxService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class JunitTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	LmService service;
	
	@Test
	public void test1() {
		System.out.println(service);
	}
	
	@Test
	public void test2() {
		service.saveReports("admin", Zhuangbei.Type_Fhzb, "xx装备", "121212121221");
	}
	
}

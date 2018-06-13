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
		//好烦阿。为什么要这样对我= =！真应该New一个GirlFriend.java的实体类，
		//程序员不需要女票的 for(;;)new GirlFriend();
		//
		service.saveReports("admin", Zhuangbei.Type_Fhzb, "xx装备", "1212121212");
	}
	
}

package cn.zbgl.lrx.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.zbgl.bean.User;
import cn.zbgl.common.CommonAction;

@Namespace("/")
@ParentPackage("struts-default")

@Controller("demoAction")  //创建对象
@Scope("prototype")    //多实例方式创建对象

public class DemoAction extends CommonAction {
	
	List<User> userLi;
	public List<User> getUserLi() {
		return userLi;
	}
	
	User user = new User();
	public User getUser() {
		return user;
	}
	
	
	public String login() {
		saveLogin(user);
		return aa;
	}
	@Action(value="/loadUserListPage",results={
			@Result(name="demo",location="/pages/lrx/demo.jsp")
	})
	public String loadUserList() {
		userLi = new ArrayList<User>();
		for(int i=0;i<10;i++) {
			User stu = new User();
			stu.setUserId("userId" + i);
			stu.setUserName("studentName" + i);
			userLi.add(stu);
		}
		System.out.println(userLi.size());
		return "demo";
	}
	
	@Override
	public String getResult() {
		return result;
	}
	
}

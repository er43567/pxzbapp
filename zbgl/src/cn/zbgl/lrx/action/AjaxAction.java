package cn.zbgl.lrx.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.zbgl.bean.User;
import cn.zbgl.common.CommonAction;
import cn.zbgl.lrx.service.LrxService;

@Namespace("/")
@ParentPackage("json-default")//非json时，则为"struts-default"
@Controller("ajaxAction")
@Scope("prototype")
public class AjaxAction extends CommonAction {
	
	@Autowired
	protected LrxService lrxService;
	
	List<User> userLi;
	public List<User> getUserLi() {
		return userLi;
	}
	public void setUserLi(List<User> userLi) {
		this.userLi = userLi;
	}
	
	User user = new User();
	public User getUser() {
		return user;
	}
	
	/*@Action( 
            value="login",  
            results={
                    @Result(name="success",location="/success.jsp",type="redirect"),  
                    @Result(name="login",location="/login.jsp",type="redirect"),  
                    @Result(name="error",location="/error.jsp",type="redirect")  
            },
            interceptorRefs={ //��ʾ����������  
                    @InterceptorRef("defaultStack"),  
                    @InterceptorRef("timer")  
            },  
            exceptionMappings={  //ӳ��ӳ������  
                    @ExceptionMapping(exception="java.lang.Exception",result="error")  
            }
    )  */
	
	@Action(value="/login"
			,results={@Result(type="json")}
			,params={"contentType", "text/html"})
	public String login() {
		System.out.println(user);
		if ("admin".equals(user.getUserId())) {
			if (!"123".equals(user.getUserPsw())) {
				setResult("psw err");
			}
		} else {
			setResult("did not registed");
		}
		System.out.println(getResult());
		return aa;
	}
	
	@Action(value="/loadUserList"
			,results={@Result(type="json")}
			,params={"contentType", "text/html"})
	public String loadUserList() {
		System.out.println("Action层被调用, stu = " + user);
		lrxService.testService();//调用Service层
		
		userLi = new ArrayList<User>();
		for(int i=0;i<10;i++) {
			User u = new User();
			u.setUserId("userId" + i);
			u.setUserName("userName"+i);
			userLi.add(u);
		}
		
		System.out.println(userLi.size());
		return aa;
	}
	
	@Override
	public String getResult() {
		return result;
	}
	
}

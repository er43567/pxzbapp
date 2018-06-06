package cn.zbgl.lm.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.zbgl.bean.Fhzb;
import cn.zbgl.common.CommonAction;

@Namespace("/")
@ParentPackage("json-default")//非json时，则为"struts-default"

@Controller("checkAction")
@Scope("prototype")
public class CheckAction extends CommonAction {
	
	public Fhzb fhzb = new Fhzb();
	
	public Fhzb getFhzb() {
		return fhzb;
	}
	
	public String submitFhzb() {
		System.out.println(fhzb);
		
		return aa;
	}
	
	@Override
	public String getResult() {
		return result;
	}
	
}

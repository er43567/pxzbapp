package cn.zbgl.lrx.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.zbgl.common.CommonAction;
import cn.zbgl.lrx.service.LrxService;

@Namespace("/")
@ParentPackage("json-default")//非json时，则为"struts-default"
@Controller("checkAction")
@Scope("prototype")
public class CheckAction extends CommonAction {
	@Autowired
	protected LrxService lrxService;
	
	
	@Action(value="/submitFhzb"
			,results={@Result(type="json")}
			,params={"contentType", "text/html"})
	public String submitFhzb() {
		/*System.out.println(fhzb);
		lrxService.saveFhzb("", fhzb);*/
		return aa;
	}
	
	@Action(value="/loadFhzb"
			,results={@Result(type="json")}
			,params={"contentType", "text/html"})
	public String loadFhzb() {
		/**
		 * 通过表单id来拿到数据
		 */
		//fhzb = lrxService.loadFhzb(fhzb.getCheckId());
		
		return aa;
	}
	
	@Override
	public String getResult() {
		return result;
	}
	
}

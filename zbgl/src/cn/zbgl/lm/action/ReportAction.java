package cn.zbgl.lm.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.zbgl.bean.Report;
import cn.zbgl.common.CommonAction;
import cn.zbgl.lm.service.LmService;
@Namespace("/")
@ParentPackage("json-default")//非json时，则为"struts-default"

@Controller("reportAction")
@Scope("prototype")
public class ReportAction extends CommonAction {

	@Autowired
	LmService service;
	
	
	Report report = new Report();
	public Report getReport() {
		return report;
	}
	/**
	 * 接收到的数据  12221212121212121
	 */
	String datas;
	public void setDatas(String datas) {
		this.datas = datas;
	}
	
	/**
	 * 提交报表
	 * 
	 */
	@Action(value="/submitReport"
			,results={@Result(type="json")}
			,params={"contentType", "text/html"})
	public String submitReport() {
		/**
		 * 谁提交的 什么数据
		 */
		/**
		 * 需要三个参数
		 * 装备类型
		 * 装备名字
		 * 数据121212121212122
		 */
		service.saveReports(getSessionUser().getUserId()
				, report.getZhuangbeiType()
				, report.getZhuangbeiName()
				, datas);
		return aa;
	}
	
	public String loadReportDatas() {
		
/*		datas = service.load...*/
		return aa;
		
	}
	
	@Override
	public String getResult() {
		return result;
	}
	
}

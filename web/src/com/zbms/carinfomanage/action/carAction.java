package com.zbms.carinfomanage.action;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zbms.all.domain.carAward;
import com.zbms.all.domain.carClass;
import com.zbms.all.domain.carInfo;
import com.zbms.all.domain.carPaper;
import com.zbms.all.domain.carPatent;
import com.zbms.all.domain.carProject;
import com.zbms.all.domain.User;
import com.zbms.carinfomanage.service.carService;
import com.zbms.carinfomanage.vo.carInfoAndOtherInfo;

import util.PageVO;

public class carAction extends ActionSupport {

	// 导出
	private String export_name;// 导出execl表的属性条件,逗号隔开
	private String export_id;// 导出execl表的ID字段条件,逗号隔开

	// 信息筛选查询
	private String time_interval;// 时间区间,逗号隔开
	private String page;// 分页
	private String tableName;// 查询的表名
	private String tableId; // 查询表的ID
	private String dataState; // 数据状态
	private String fuzzy_query;// 模糊查询字段

	// 注入
	private carService carService;

	private carInfo carInfo;
	private carAward carAward;
	private carPatent carPatent;
	private carProject carProject;
	private carClass carClass;
	private carPaper carPaper;

	private User sessionuser;

	public carAction() {
		sessionuser = (User) ActionContext.getContext().getSession().get("loginuser");
	}

	public void setcarService(carService carService) {
		this.carService = carService;
	}

	// getInfoClassBytableName()执行返回后参数为对象，通过tableName获取，以下称返回的对象为object0
	/**
	 * 保存学生信息 object0内该包含日期，主键除外外的其他信息
	 */
	public void setcarAllInfo() {
		try {
			String msg = carService.setcarAllInfo(getInfoObjectBytableName());
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write("{\"result\":\"" + msg + "\"}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除学生信息 object0内至少id应当含有
	 */
	public void deletecarAllInfo() {
		try {
			String msg = carService.deletecarInfo(getInfoObjectBytableName());
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write("{\"result\":\"" + msg + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新学生信息 object0内至少id应当含有全部信息
	 */
	public void updatecarAllInfo() {
		try {
			String msg = carService.updatecarAllInfo(getInfoObjectBytableName());
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write("{\"result\":\"" + msg + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取学生信息（所有） 通过tableName辨别需要获取什么信息
	 */
	public void getcarAllInfo() {
		try {
			PageVO<carInfoAndOtherInfo> pageVo = carService.getcarAllInfo(tableName, page);
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write(new Gson().toJson(pageVo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取学生信息（单个） object0内至少表id和carId应当含有
	 */
	public void getcarOneInfo() {
		try {
			carInfoAndOtherInfo obj = carService.getcarOneInfo(getInfoObjectBytableName());
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write(new Gson().toJson(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object getInfoObjectBytableName() {
		switch (this.tableName) {
		case "carInfo":
			return carInfo;
		case "carPaper":
			return carPaper;
		case "carPatent":
			return carPatent;
		case "carProject":
			return carProject;
		case "carAward":
			return carAward;
		case "carClass":
			return carClass;
		default:
			return null;
		}
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public carInfo getcarInfo() {
		return carInfo;
	}

	public void setcarInfo(carInfo carInfo) {
		this.carInfo = carInfo;
	}

	public carAward getcarAward() {
		return carAward;
	}

	public void setcarAward(carAward carAward) {
		this.carAward = carAward;
	}

	public carPatent getcarPatent() {
		return carPatent;
	}

	public void setcarPatent(carPatent carPatent) {
		this.carPatent = carPatent;
	}

	public carProject getcarProject() {
		return carProject;
	}

	public void setcarProject(carProject carProject) {
		this.carProject = carProject;
	}

	public carClass getcarClass() {
		return carClass;
	}

	public void setcarClass(carClass carClass) {
		this.carClass = carClass;
	}

	public carPaper getcarPaper() {
		return carPaper;
	}

	public void setcarPaper(carPaper carPaper) {
		this.carPaper = carPaper;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getExport_name() {
		return export_name;
	}

	public void setExport_name(String export_name) {
		this.export_name = export_name;
	}

	public String getExport_id() {
		return export_id;
	}

	public void setExport_id(String export_id) {
		this.export_id = export_id;
	}

	public String getTime_interval() {
		return time_interval;
	}

	public void setTime_interval(String time_interval) {
		this.time_interval = time_interval;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getDataState() {
		return dataState;
	}

	public void setDataState(String dataState) {
		this.dataState = dataState;
	}

	public String getFuzzy_query() {
		return fuzzy_query;
	}

	public void setFuzzy_query(String fuzzy_query) {
		this.fuzzy_query = fuzzy_query;
	}

	public User getSessionuser() {
		return sessionuser;
	}

	public void setSessionuser(User sessionuser) {
		this.sessionuser = sessionuser;
	}

	public String getPage() {
		return page;
	}

	public String getTableName() {
		return tableName;
	}

	public carService getcarService() {
		return carService;
	}

}

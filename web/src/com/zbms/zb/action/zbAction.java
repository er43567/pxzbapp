package com.zbms.zb.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zbms.all.domain.zbAward;
import com.zbms.all.domain.zbInfo;
import com.zbms.all.domain.zbPaper;
import com.zbms.all.domain.zbPatent;
import com.zbms.all.domain.zbProject;
import com.zbms.all.domain.zbWorks;
import com.zbms.all.domain.User;
import com.zbms.zb.vo.TableInfoAndUserVo;
import com.zbms.zb.service.zbService;

import util.*;

public class zbAction extends ActionSupport {
	private zbService zbService;
	// 登录用户
	private User sessionuser;

	// 导出
	private String export_name;// 导出execl表的属性条件,逗号隔开
	private String export_id;// 导出execl表的ID字段条件,逗号隔开
	private String time_interval;// 时间区间

	// 附件
	private List<File> _file; // execl,图片文件
	private List<String> _fileFileName; // file+FileName为固定写法
	private List<String> _fileContentType; // file+ContentType为固定写法
	private String downloadInfoId; // 图片下载的信息表的id

	// 查询条件
	private String page; // 分页
	private String tableName;// 查询的表名
	private String tableId; // 查询表的ID
	private String dataState; // 数据状态
	private String fuzzy_query;// 模糊查询字段

	// 用户名字
	private String username;

	// 信息表
	private zbAward zbAward;
	private zbInfo zbInfo;
	private zbPaper zbPaper;
	private zbPatent zbPatent;
	private zbProject zbProject;
	private zbWorks zbWorks;
	private User user;
	private Object obj;

	public zbAction() {
		sessionuser = (User) ActionContext.getContext().getSession().get("loginuser");
	}

	// 教职工分页获取指定的信息
	public void userGetTableInfoInPaging() {
		try {
			// 给Object对象赋值
			getObjectByTableName(tableName);
			PageVO<Object> listAdmin = zbService.getTableInfoInPaging(sessionuser.getUserId(), tableName,
					page == null ? "1" : page, time_interval, obj, fuzzy_query);
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write(new Gson().toJson(listAdmin));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 通过tablename来判断给信息对象赋值
	private void getObjectByTableName(String tableName) {
		if (("zbAward").equals(tableName)) {
			obj = zbAward;
		} else if (("zbInfo").equals(tableName)) {
			obj = zbInfo;
		} else if (("zbPaper").equals(tableName)) {
			obj = zbPaper;
		} else if (("zbPatent").equals(tableName)) {
			obj = zbPatent;
		} else if (("zbProject").equals(tableName)) {
			obj = zbProject;
		} else if (("zbWorks").equals(tableName)) {
			obj = zbWorks;
		} else {
			return;
		}
	}

	// 用户通过ID获取单条信息
	public void userGetTableInfoByTableId() {
		try {
			TableInfoAndUserVo obj = zbService.userGetTableInfoByTableId(tableName, tableId);
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write(new Gson().toJson(obj));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ---用户获取自己的全部教职工信息
	public void userGetzbInfo() {
		try {
			TableInfoAndUserVo zbInfo = zbService.userGetzbInfo(sessionuser.getUserId());
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write(new Gson().toJson(zbInfo));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 管理员获取输入用户名字，获取用户的id排名
	public void getUserIdOrderingByUserName() {
		try {
			String result = zbService.getUserIdOrderingByUserName(user.getUserName());
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write("{\"result\":\"" + result + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 用户修改,添加信息
	public void userSetTableInfo() {
		try {
			Object obj = null;
			if (("zbAward").equals(tableName)) {
				obj = zbAward;
			} else if (("zbInfo").equals(tableName)) {
				obj = zbInfo;
			} else if (("zbPaper").equals(tableName)) {
				obj = zbPaper;
			} else if (("zbPatent").equals(tableName)) {
				obj = zbPatent;
			} else if (("zbProject").equals(tableName)) {
				obj = zbProject;
			} else if (("zbWorks").equals(tableName)) {
				obj = zbWorks;
			} else {
				return;
			}
			String result = zbService.addTableInfo(sessionuser.getUserId(), obj, tableName);
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 用户提交信息至管理员审核(-----除基本信息外------)..
	public void userPuchInfoToadmin() {
		try {
			String result = zbService.PuchInfoToadmin(tableName, tableId);
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write("{\"result\":\"" + result + "\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 用户提交基本信息补全并将信息状态修改至管理员审核状态
	public void userCompleteBasicInformation() {
		try {
			String result = zbService.completeBasicInformation(zbInfo, sessionuser.getUserId(), username);
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write("{\"result\":\"" + result + "\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 获取用户名字信息
	public void userGetUserName() {
		try {
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write("{\"result\":\"" + sessionuser.getUserName() + "\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 导出信息excel表 用MAP集合
	public void userExportExcelCollection() {
		XSSFWorkbook workbook = zbService.getExcel(export_name, tableName, export_id);
		OutputStream out = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			out = response.getOutputStream();
			response.setHeader("Content-disposition", "attachment; filename=" + tableName + ".xls");// filename是下载的xls的名，建议最好用英文
			response.setContentType("application/msexcel;charset=UTF-8");// 设置类型
			response.setHeader("Pragma", "No-cache");// 设置头
			response.setHeader("Cache-Control", "no-cache");// 设置头
			response.setDateHeader("Expires", 0);// 设置日期头
			workbook.write(out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 用户附件上传
	public void userAttachmentUpload() {
		try {
			System.out.println(_file.get(0));
			String result = zbService.userAttachmentUpload(_file, _fileFileName, _fileContentType,
					sessionuser.getUserId(), tableName, tableId);
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write("{\"result\":\"" + result + "\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 图片打包下载
	public void downloadAttachment() {
		HttpServletResponse response = ServletActionContext.getResponse();
		File file = zbService.downloadAttachment("张三", tableName, downloadInfoId);
		try {
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			// 如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
			response.setHeader("Content-Disposition",
					"attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				File f = new File(file.getPath());
				f.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setzbService(zbService zbService) {
		this.zbService = zbService;
	}

	public void setzbAward(zbAward zbAward) {
		this.zbAward = zbAward;
	}

	public void setzbInfo(zbInfo zbInfo) {
		this.zbInfo = zbInfo;
	}

	public void setzbPaper(zbPaper zbPaper) {
		this.zbPaper = zbPaper;
	}

	public void setzbPatent(zbPatent zbPatent) {
		this.zbPatent = zbPatent;
	}

	public void setzbProject(zbProject zbProject) {
		this.zbProject = zbProject;
	}

	public void setzbWorks(zbWorks zbWorks) {
		this.zbWorks = zbWorks;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public void setExport_name(String export_name) {
		this.export_name = export_name;
	}

	public void setExport_id(String export_id) {
		this.export_id = export_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTime_interval(String time_interval) {
		this.time_interval = time_interval;
	}

	public void setDataState(String dataState) {
		this.dataState = dataState;
	}

	public void set_file(List<File> _file) {
		this._file = _file;
	}

	public void set_fileFileName(List<String> _fileFileName) {
		this._fileFileName = _fileFileName;
	}

	public void set_fileContentType(List<String> _fileContentType) {
		this._fileContentType = _fileContentType;
	}

	public void setDownloadInfoId(String downloadInfoId) {
		this.downloadInfoId = downloadInfoId;
	}

	public zbAward getzbAward() {
		return zbAward;
	}

	public zbInfo getzbInfo() {
		return zbInfo;
	}

	public zbPaper getzbPaper() {
		return zbPaper;
	}

	public zbPatent getzbPatent() {
		return zbPatent;
	}

	public zbProject getzbProject() {
		return zbProject;
	}

	public zbWorks getzbWorks() {
		return zbWorks;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFuzzy_query(String fuzzy_query) {
		this.fuzzy_query = fuzzy_query;
	}

}

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
  
  <script type="text/javascript">
  
  $(document).ready(function() {
	 
	 /*
	  这里调用了  ../LrxAjaxAction!loadUserList 接口
	  返回用户对象列表
	 */
	 
	 $.post("loadUserList", { "user.userId":66 }, function(data) {
		 
		  var list = data.userLi;//拿到用户列表
		  
		  alert("获取数据：" + data.result);
		  
		  //遍历用户
		  for(var i=0;i<list.length;i++) {
			  
			  var item = list[i];//第i个用户
			  
			  //对应数据库字段
			  $("#ajax-demo").html( $("#ajax-demo").html() + item.userName + "<br>");
			  
		  }
		  
	  });
	  
  });
  
  </script>
  </head>
  
  <body>
  	
  	<div id='ajax-demo'></div>
  	
  	<!-- 调用接口 ，跳转页面，获取到数据 -->
  	<a href="loadUserListPage">DemoTest</a>
  	
  </body>
  
</html>

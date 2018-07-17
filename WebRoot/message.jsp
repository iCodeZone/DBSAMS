<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员主页</title>
	<link rel="stylesheet" href="BootStrap/bootstrap.css">
    <link rel="stylesheet" href="BootStrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" href="BootStrap/3.3.7/bootstrap.min.js">
      <style type="text/css">
      #header{

}
      </style>

  </head>
  
  <body>
   <div class="page-header" id="header">
  <h1><strong><span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>管理员主页</strong></h1>
  </div>
 
<ul class="nav nav-pills nav-justified">
  <li role="presentation"><a href="luru.jsp">信息录入</a></li>
  <li role="presentation"><a href="select.jsp">信息查询</a></li>
</ul>
 </div>
     
     
      <script src="BootStrap/jquery-3.3.1.js"></script>
     <script src="BootStrap/bootstrap.js"></script>
     
  </body>
</html>

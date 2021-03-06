<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Bean.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
  <head>
  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../BootStrap/bootstrap.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.js">
    <link rel="stylesheet" href="css/TeacherPage.css">
    <title>教师管理平台</title>

  </head>
  
  <body>
     
    <%TeacherBean teacher=(TeacherBean)session.getAttribute("teacher"); %>
    <div class="row panel panel-default" style="width:1380px;">
      <div class="col-md-2">
        <img src="../Picture/3.jpg" class="img-circle" width="150px" height="120px">
      </div>
     
      <div class="col-md-1">
        <h1><small><%=teacher.getTname() %></small></h1>
        <h1><small><%=teacher.getTno() %></small></h1>
      </div>
    </div>
  
     <div class="panel panel-default" style="width:1365px;">
     <ul class="nav nav-tabs" style="width:1200px;">
     
      <li class="dropdown">
        <ul class="nav nav-tabs">
          <li style="width:162px;text-align:center;" id="one"><a><span class="glyphicon glyphicon-user"></span>个人信息</a></li>
        </ul>
      </li>
     
     <li class="dropdown" style="width:162px;text-align:center;">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
          <span class="glyphicon glyphicon-th"></span>教学课程 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
          <li><a href="#" id="first" name="2016-2017(1)">2016-2017(1)</a></li>
          <li><a href="#" id="second" name="2016-2017(2)">2016-2017(2)</a></li>
          <li><a href="#" id="third" name="2017-2018(1)">2017-2018(1)</a></li>
          <li><a href="#" id="four" name="2017-2018(2)">2017-2018(2)</a></li>
        </ul>
     </li>
     
     <li class="dropdown" style="width:162px;text-align:center;">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
          <span class="glyphicon glyphicon-th-list"></span>成绩录入 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
          <li><a href="#" id="five" name="2016-2017(1)">2016-2017(1)</a></li>
          <li><a href="#" id="six" name="2016-2017(2)">2016-2017(2)</a></li>
          <li><a href="#" id="seven" name="2017-2018(1)">2017-2018(1)</a></li>
          <li><a href="#" id="eight" name="2017-2018(2)">2017-2018(2)</a></li>
        </ul>
      </li>
          
    </ul>
   </div>


     <script src="../BootStrap/jquery-3.3.1.js"></script>
     <script src="../BootStrap/bootstrap.js"></script>
     <script type="text/javascript" src="js/1.js"></script>
     
  </body>
</html>

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
    <link rel="stylesheet" href="css/ScoreMessage.css">
    <title>成绩修改页面</title>

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

     <div id="kcname" class="panel panel-default" style="width:1365px;">
       <h3 align="left">
         <%String kcname=(String)session.getAttribute("kcname"); %>
         <span class="glyphicon glyphicon-paperclip"></span>
         <em><%=kcname %></em>
       </h3>
     </div>

     <%ArrayList<MemberBean> array=(ArrayList<MemberBean>)session.getAttribute("member"); %>
     <div id="message">
     <form action="/SAMS/MClass" method="post">
     <div>
     <div class="panel panel-default">
       <table class="table table-hover">
         <tr><td>姓名</td><td>学号</td><td>专业</td><td>成绩</td><td>成绩录入</td></tr>
         <%for(int i=0;i<array.size();i++){ %>
         <%MemberBean member=array.get(i); %>
         <tr>
           <td><%=member.getSname() %></td>
           <td><%=member.getSno() %></td>
           <td><%=member.getMname() %></td>
           <td><%=member.getGrade() %></td>
           <td><input type="text" class="form-control" style="height:25px;width:50px;" name=<%=i %>></td>
         </tr>
         <%} %>
       </table>                  
     </div>
     <button class="btn btn-info" style="margin-bottom:10px;margin-left:955px;height:30px;">确认提交</button>
     </div>
     </form>
     </div>

     <script src="../BootStrap/jquery-3.3.1.js"></script>
     <script src="../BootStrap/bootstrap.js"></script>
     <script type="text/javascript" src="js/3.js"></script>
     
  </body>
</html>

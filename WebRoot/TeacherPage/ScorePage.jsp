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
    <link rel="stylesheet" href="css/ScorePage.css">
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

     <%ArrayList<CourseBean> arraylist=(ArrayList<CourseBean>)session.getAttribute("classes"); %>
     
     <div id="term" class="panel panel-default" style="width:1365px;">
       <h3 align="left">
         <%String term=(String)session.getAttribute("date"); %>
         <span class="glyphicon glyphicon-paperclip"></span>
         <em><%=term %></em>
       </h3>
     </div>
   
     <div id="kecheng" class="panel panel-default" style="width:1365px;">
       <%int n=4; %>
       <%for(int i=1;i<=arraylist.size();i++){ %>   
       <%CourseBean course=arraylist.get(i-1);%>
       <div class="panel panel-default" style="width:200px;">
         <img src="../Picture/2.jpg" class="pict" id="pict"name=<%=i %>><br/>
         <h2 style="text-align:center;"><small><%=course.getCname() %></small></h2>
         
         <div style="margin-top:20px;">
           <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" style="width:200px;">
                              课程相关信息
           </button>
           <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
             <div class="modal-dialog" role="document">
               <div class="modal-content">
                 <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                     <h4 class="modal-title" id="myModalLabel">课程信息</h4>
                 </div>
                 <div class="modal-body">
                   <table class="table table-striped">
                     <tr><td>课程编号<td><td>课程名<td><td>课程类型<td><td>课程学分<td><td>课程学时<td></tr>
                     <%for(int j=0;j<arraylist.size();j++){ %>
                       <tr>
                         <td><%=course.getCno() %><td>
                         <td><%=course.getCname() %><td>
                         <td><%=course.getCtype() %><td>
                         <td><%=course.getCredits() %><td>
                         <td><%=course.getCperiod() %><td>
                       </tr>        
                     <%} %>
                   </table>
                 </div>
                 <div class="modal-footer">
                   <button type="button" class="btn btn-info" data-dismiss="modal" style="width:150px;">Close</button>                   
                 </div>
               </div>
             </div>
           </div>
         </div>
         
       </div>                  
       <%} %>     
     </div>


     <script src="../BootStrap/jquery-3.3.1.js"></script>
     <script src="../BootStrap/bootstrap.js"></script>
     <script type="text/javascript" src="js/3.js"></script>
     
  </body>
</html>

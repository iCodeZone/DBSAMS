<%@ page language="java" import="java.util.*,Bean.*" pageEncoding="utf-8"%>

<html lang="zh-CN">
  <head>
    <title>个人主页</title>
	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="BootStrap/bootstrap.css">
    <link rel="stylesheet" href="BootStrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="BootStrap/3.3.7/bootstrap.min.js">
    
    <style type="text/css">
   #data{
   display:none;
    }
     #data1{
   display:none;
    }
    body{
    background-image:url(4.jpg);
    background-size: 100% 100%;
    }
    </style>
    
  </head>
  
  <body>
  <%StudentBean s = (StudentBean)session.getAttribute("student"); %>
  
   <div class="page-header">
 <img src="1.jpg" width="100" height="80" class="img-circle"/>
 </div>
   <ul class="nav nav-pills nav-justified">
<li role="presentation" id="one"><a><font color="black"><span class="glyphicon glyphicon-user" ></span>&nbsp;个人信息</font></a></li>
<li role="presentation" id="two"><a><font color="black"><span class="glyphicon glyphicon-credit-card" ></span>&nbsp;修改密码</font></a></li>
   <li class="dropdown">
   <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" >
         <font color="black"><span class="glyphicon glyphicon-book" ></span>&nbsp; 我的课程<span class="caret"></span></font>
   </a>
   
    <ul class="dropdown-menu">
     <li><a href="SGrade?action=2016-2017(1)">2016-2017(1)</a></li>
     <li><a href="SGrade?action=2016-2017(2)">2016-2017(2)</a></li>
     <li><a href="SGrade?action=2017-2018(1)">2017-2018(1)</a></li>
     <li><a href="SGrade?action=2017-2018(2)">2017-2018(2)</a></li>
    </ul></li> 
    
</ul>
  <table class="table" id="data">
<tr style="height:80px;"><td><span class="label label-default" style="line-height:40px;">姓&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span></td><td style="line-height:40px;"><%=s.getSname() %></td></tr>
<tr style="height:80px;"><td><span class="label label-default" style="line-height:40px;">学&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</span></td><td style="line-height:40px;"><%=s.getSno() %></td></tr>
<tr style="height:80px;"><td><span class="label label-default" style="line-height:40px;">性&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span></td><td style="line-height:40px;"><%=s.getSsex() %></td></tr>
<tr style="height:80px;"><td><span class="label label-default" style="line-height:40px;">年&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</span></td><td style="line-height:40px;"><%=s.getSage() %></td></tr>
<tr style="height:80px;"><td><span class="label label-default" style="line-height:40px;">生源所在地:</span></td><td style="line-height:40px;"><%=s.getSaddr() %></td></tr>
 </table> 
 
 <form action="SPassword" method="post">
   <table class="table" id="data1">
<tr><td><span class="label label-info" style="line-height:30px;">原密码</span></td><td><input type="text" class="form-control" placeholder="输入原密码" name="oldpassword"></td></tr>
<tr><td><span class="label label-info" style="line-height:30px;">新密码</span></td><td><input type="text" class="form-control" placeholder="输入新密码" name="newpassword"></td></tr>
<tr><td colspan="2" align="right"><button type="submit" class="btn btn-primary">确定修改</button>
</td></tr>
 </table> 
 <%
String a=(String)session.getAttribute("success");
System.out.println(a);
if(a!=null&&a.equals("0")){
%>
<script type="text/javascriprt">
alert("修改失败");
</script>
<%
session.removeAttribute("success");
}
if(a!=null&&a.equals("1")){
 %>
 <script type="text/javascript">
alert("修改成功");
</script>
<%session.removeAttribute("success");
}
 %>
 </form>
 
 <script src="BootStrap/jquery-3.3.1.js"></script>
     <script src="BootStrap/bootstrap.js"></script>
     
      <script>
       $(document).ready(function(){
  	   $("#one").click(function(){
  	     $("#data").css("display","block");
  	     $("#data1").css("display","none");
       });
        $("#two").click(function(){
  	     $("#data1").css("display","block");
  	     $("#data").css("display","none"); 
       });
     });
      </script>
      

  </body>
</html>

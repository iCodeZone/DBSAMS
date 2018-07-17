<%@ page language="java" import="java.util.*,Bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息查询</title>
    <link rel="stylesheet" href="BootStrap/bootstrap.css">
    <link rel="stylesheet" href="BootStrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" href="BootStrap/3.3.7/bootstrap.min.js">
      
<style type="text/css">
  #select1{
   display:none;
    }
      #select2{
   display:none;
    }
     #select3{
   display:none;
    }
     #select4{
   display:none;
    }
     #select5{
   display:none;
    }
    body{
    background-image:url(3.jpg);
    background-size: 100% 100%;
    }
    </style>

  </head>
  
  <body>
      <script src="BootStrap/jquery-3.3.1.js"></script>
     <script src="BootStrap/bootstrap.js"></script>
         <script>
function jump(){
window.location.href="message.html";
}
</script>

      <div class="page-header">
  <h1><strong><span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>信息查询</strong></h1>
  </div>
    
     <ul class="nav nav-pills nav-justified">
<li role="presentation" id="one"><a><strong><font color="black"><span class="glyphicon glyphicon-tag" ></span>&nbsp;学生</font></strong></a></li>
<li role="presentation" id="two"><a><strong><font color="black"><span class="glyphicon glyphicon-tags" ></span>&nbsp;教师</font></strong></a></li> 
<li role="presentation" id="three"><a><strong><font color="black"><span class="glyphicon glyphicon-book" ></span>&nbsp;课程</font></strong></a></li> 
<li role="presentation" id="four"><a><strong><font color="black"><span class="glyphicon glyphicon-flag" ></span>&nbsp;班级</font></strong></a></li> 
<li role="presentation" id="five"><a><strong><font color="black"><span class="glyphicon glyphicon-education" ></span>&nbsp;专业</font></strong></a></li> 
</ul>

<%
 String delete=(String)session.getAttribute("delete");
if(delete!=null&&delete.equals("0")){
%>
<script type="text/javascript">
alert("删除失败");
</script>
<%
session.removeAttribute("delete");
}
if(delete!=null&&delete.equals("1")){
 %>
 <script type="text/javascript">
alert("删除成功");
</script>
<%session.removeAttribute("delete");
}
String b=(String)session.getAttribute("page");
if(b!=null&&b.equals("1")){
%>
  
<script type="text/javascript">
$(document).ready(function(){
  $("#select1").css("display","block");
  $("#select2").css("display","none");
  	     $("#select3").css("display","none");
  	      $("#selec4").css("display","none");
  	       $("#select5").css("display","none");
  	       });
</script>
<%
}
else if(b!=null&&b.equals("2")){
 %>
 <script type="text/javascript">
 $(document).ready(function(){
  $("#select2").css("display","block");
  $("#select1").css("display","none");
  	     $("#select3").css("display","none");
  	      $("#selec4").css("display","none");
  	       $("#select5").css("display","none");
  	       });
</script>
<%
}
else if(b!=null&&b.equals("3")){
 %>
 <script type="text/javascript">
  $(document).ready(function(){
  $("#select3").css("display","block");
  $("#select1").css("display","none");
  	     $("#select2").css("display","none");
  	      $("#selec4").css("display","none");
  	       $("#select5").css("display","none");
  	       });
</script>
<%
}
else if(b!=null&&b.equals("4")){
 %>
 <script type="text/javascript">
   $(document).ready(function(){
 $("#select4").css("display","block");
  $("#select1").css("display","none");
  	     $("#select2").css("display","none");
  	      $("#selec3").css("display","none");
  	       $("#select5").css("display","none");
  	       });
</script>
<%
}
else if(b!=null&&b.equals("5")){
 %>
 <script type="text/javascript">
    $(document).ready(function(){
  $("#select5").css("display","block");
  $("#select2").css("display","none");
  	     $("#select3").css("display","none");
  	      $("#selec4").css("display","none");
  	       $("#select1").css("display","none");
  	       });
</script>
<%
}
session.removeAttribute("page");
%>

<div class="col-lg-6" id="select1">

      <%MSBean s = (MSBean)session.getAttribute("student1");
       if(s!=null){
      %>
     <table class="table">
     <tr><td><span class="label label-info">学生学号</span></td>
     <td><span class="label label-info">学生姓名</span></td>
     <td><span class="label label-info">学生性别</span></td>
     <td><span class="label label-info">学生年龄</span></td>
     <td><span class="label label-info">学生地址</span></td>
     <td><span class="label label-info">学生专业</span></td>
     <td><span class="label label-info">学生班级</span></td>
     <td><span class="label label-info">学生学分</span></td></tr>
     <tr><td align="middle"><span class="label label-default"><%=s.getSno() %></span></td>
     <td align="middle"><span class="label label-default"><%=s.getSname() %></span></td>
     <td align="middle"><span class="label label-default"><%=s.getSsex() %></span></td>
     <td align="middle"><span class="label label-default"><%=s.getSage() %></span></td>
     <td align="middle"><span class="label label-default"><%=s.getSaddr() %></span></td>
     <td align="middle"><span class="label label-default"><%=s.getMname() %></span></td>
     <td align="middle"><span class="label label-default"><%=s.getGno() %></span></td>
     <td align="middle"><span class="label label-default"><%=s.getScredit() %></span></td>
     <td><form action="/SAMS/CheckStudent" method="get"><input type="hidden" value=<%=s.getSno() %> name="sno"><input type="submit" value="删除"  class="btn btn-primary"></form></td></tr>
     <%}  session.removeAttribute("student1");%>
       </table>
     <table class="table">
     <tr><td> <div class="input-group" >
    <form action="/SAMS/CheckStudent" method="post">
      <input type="text" class="form-control" name="sno" placeholder="输入学号搜索学生信息">
      &nbsp;
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit" id="serch1">搜索</button>
      </span>
      </form>
    </div>
    </td></tr>
    </table>
   
  </div>
  

<div class="col-lg-6" id="select2">

     <table class="table">
      <%TeacherBean t = (TeacherBean)session.getAttribute("teacher1"); 
      if(t!=null){
      %>
     <tr><td align="middle"><span class="label label-info">教师编号</span></td>
     <td align="middle"><span class="label label-info">教师姓名</span></td>
     <td align="middle"><span class="label label-info">教师性别</span></td>
     <td align="middle"><span class="label label-info">教师年龄</span></td>
     <td align="middle"><span class="label label-info">教师职称</span></td>
     <td align="middle"><span class="label label-info">教师电话</span></td></tr>
     <tr><td align="middle"><span class="label label-default"><%=t.getTno() %></span></td>
     <td align="middle"><span class="label label-default"><%=t.getTname() %></span></td>
     <td align="middle"><span class="label label-default"><%=t.getTsex() %></span></td>
     <td align="middle"><span class="label label-default"><%=t.getTage() %></span></td>
     <td align="middle"><span class="label label-default"><%=t.getTtitle() %></span></td>
     <td align="middle"><span class="label label-default"><%=t.getTtel() %></span></td>
     <td><form action="/SAMS/CheckTeacher"><input type="hidden" value=<%=t.getTno() %> name="tno"> <input type="submit"  value="删除"  class="btn btn-primary"></form></td></tr>
     <%}session.removeAttribute("teacher1");
     %>
     </table>
     <table class="table">
     <tr><td> 
     <div class="input-group" >
    <form action="/SAMS/CheckTeacher" method="post">
      <input type="text" class="form-control"  name="tno" placeholder="输入教师编号搜索教师信息">
      &nbsp;
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit" id="serch2">搜索</button>
      </span>
      </form>
      
    </div>
  </td></tr>
   </table>

    </div>

  
  <div class="col-lg-6" id="select3">
      

     <table class="table">
     <%CATBean c = (CATBean)session.getAttribute("course1"); 
      if(c!=null){
      %>
     <tr><td align="middle"><span class="label label-info">课程编号</span></td>
     <td align="middle"><span class="label label-info">课程名称</span></td>
     <td align="middle"><span class="label label-info">课程类型</span></td>
     <td align="middle"><span class="label label-info">任课教师</span></td>
     <td align="middle"><span class="label label-info">课程学分</span></td>
     <td align="middle"><span class="label label-info">课程学时</span></td></tr>
     <tr><td align="middle"><span class="label label-default"><%=c.getCno() %></span></td>
     <td align="middle"><span class="label label-default"><%=c.getCname() %></span></td>
     <td align="middle"><span class="label label-default"><%=c.getCtype() %></span></td>
     <td align="middle"><span class="label label-default"><%=c.getTname() %></span></td>
     <td align="middle"><span class="label label-default"><%=c.getCredits() %></span></td>
     <td align="middle"><span class="label label-default"><%=c.getCperiod() %></span></td>
     <td><form action="/SAMS/CheckCourse" method="get"><input type="hidden" value=<%=c.getCno() %> name="cno"> <input type="submit"  value="删除"  class="btn btn-primary"></form></td></tr>
    <%
     }session.removeAttribute("course1");
     %>
          </table>
     <table class="table">
<tr><td><div class="input-group" >
    <form action="/SAMS/CheckCourse" method="post">
      <input type="text" class="form-control" name="cno" placeholder="输入课程编号搜索课程信息">
      &nbsp;
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit" id="serch3">搜索</button>
      </span>
      </form>
    </div>
</td></tr>
     </table>

     </div>
  
  <div class="col-lg-6" id="select4">
  
     <table class="table">
     <%ClassBean g = (ClassBean)session.getAttribute("class1"); 
     if(g!=null){
     %>
     <tr><td align="middle"><span class="label label-info">专业编号</span></td>
     <td align="middle"><span class="label label-info">班级编号</span></td>
     <td align="middle"><span class="label label-info">班级名称</span></td></tr>
     <tr><td align="middle"><%=g.getMno() %></td>
     <td align="middle"><span class="label label-default"><%=g.getGno() %></span></td>
     <td align="middle"><span class="label label-default"><%=g.getGname() %></span></td></tr>
  <%}session.removeAttribute("class1"); %>
    </table>
     <table class="table">
     <tr><td><div class="input-group" >
     <form action="/SAMS/CheckClass" method="post">
      <input type="text" class="form-control" name="gno" placeholder="输入班级编号搜索班级信息">
      &nbsp;
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit" id="serch4">搜索</button>
      </span>
      </form>
    </div>
    </td>
    </tr>
     </table>
    
  </div>
  
  <div class="col-lg-6" id="select5">
  
      <%MajorBean m = (MajorBean)session.getAttribute("major1"); 
       if(m!=null){
      %>
     <table class="table">
     <tr><td align="middle"><span class="label label-info">专业编号</span></td>
     <td align="middle"><span class="label label-info">专业名称</span></td></tr>
     <tr><td align="middle"><span class="label label-default"><%=m.getMno() %></span></td>
     <td align="middle"><span class="label label-default"><%=m.getMname() %></span></td></tr>
     <%}session.removeAttribute("major1"); %>
       </table>
     <table class="table">
     <tr>
     <td>
     <div class="input-group" >
    <form action="/SAMS/CheckMajor" method="post">
      <input type="text" class="form-control" name="mno" placeholder="输入专业编号搜索专业信息">
      &nbsp;
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit" id="serch5">搜索</button>
      </span>
      </form>
    </div></td>
    </tr>
     </table>
   
  </div>
  
   <table  class="table"><tr>
   <td style="height:1000px;" align="middle">
  <input type="button" value="返回主页" onclick=jump() class="btn btn-primary">
  </td>
  </tr>
 </table>

      
      <script>
      $(document).ready(function(){
  	   $("#one").click(function(){
  	     $("#select1").css("display","block");
  	     $("#select2").css("display","none");
  	     $("#select3").css("display","none");
  	      $("#select4").css("display","none");
  	        $("#select5").css("display","none");
       });
       $("#two").click(function(){
  	     $("#select2").css("display","block");
  	     $("#select1").css("display","none");
  	     $("#select3").css("display","none");
  	      $("#select4").css("display","none");
  	        $("#select5").css("display","none");
       });
       $("#three").click(function(){
  	     $("#select3").css("display","block");
  	     $("#select1").css("display","none");
  	     $("#select2").css("display","none");
  	      $("#select4").css("display","none");
  	        $("#select5").css("display","none");
       });
       $("#four").click(function(){
  	     $("#select4").css("display","block");
  	     $("#select1").css("display","none");
  	     $("#select2").css("display","none");
  	      $("#select3").css("display","none");
  	        $("#select5").css("display","none");
       });
       $("#five").click(function(){
  	     $("#select5").css("display","block");
  	     $("#select1").css("display","none");
  	     $("#select2").css("display","none");
  	      $("#select3").css("display","none");
  	        $("#select4").css("display","none");
       });
       });
       </script>
     
  </body>
</html>

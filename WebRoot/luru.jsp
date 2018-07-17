<%@ page language="java" import="java.util.*,Bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息录入</title>
    <link rel="stylesheet" href="BootStrap/bootstrap.css">
    <link rel="stylesheet" href="BootStrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" href="BootStrap/3.3.7/bootstrap.min.js">

    <style type="text/css">
  #data1{
   display:none;
    }
     #data2{
   display:none;
    }
     #data3{
   display:none;
    }
      #data4{
   display:none;
    }
    #data5{
   display:none;
    }
    body{
    background-image:url(1.jpg);
    background-size: 80% 100%;
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
  <h1><strong><span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>信息录入</strong></h1>
  </div>
  
 <ul class="nav nav-pills nav-justified">
<li role="presentation" id="one"><a><strong><span class="glyphicon glyphicon-tag" ></span>&nbsp;学生</strong></a></li>
<li role="presentation" id="two"><a><strong><span class="glyphicon glyphicon-tags" ></span>&nbsp;教师</strong></a></li> 
<li role="presentation" id="three"><a><strong><span class="glyphicon glyphicon-book" ></span>&nbsp;课程</strong></a></li> 
<li role="presentation" id="four"><a><strong><span class="glyphicon glyphicon-flag" ></span>&nbsp;班级</strong></a></li> 
<li role="presentation" id="five"><a><strong><span class="glyphicon glyphicon-education" ></span>&nbsp;专业</strong></a></li> 
</ul>

<%
String b=(String)session.getAttribute("page");
if(b!=null&&b.equals("1")){
%>
  
<script type="text/javascript">
$(document).ready(function(){
  $("#data1").css("display","block");
  $("#data2").css("display","none");
  	     $("#data3").css("display","none");
  	      $("#data4").css("display","none");
  	       $("#data5").css("display","none");
  	       });
</script>
<%
}
else if(b!=null&&b.equals("2")){
 %>
 <script type="text/javascript">
 $(document).ready(function(){
  $("#data2").css("display","block");
    $("#data1").css("display","none");
  	     $("#data3").css("display","none");
  	      $("#data4").css("display","none");
  	       $("#data5").css("display","none");
  	        });
</script>
<%
}
else if(b!=null&&b.equals("3")){
 %>
 <script type="text/javascript">
  $(document).ready(function(){
  $("#data3").css("display","block");
    $("#data1").css("display","none");
  	     $("#data2").css("display","none");
  	      $("#data4").css("display","none");
  	       $("#data5").css("display","none");
  	         });
</script>
<%
}
else if(b!=null&&b.equals("4")){
 %>
 <script type="text/javascript">
   $(document).ready(function(){
  $("#data4").css("display","block");
    $("#data1").css("display","none");
  	     $("#data3").css("display","none");
  	      $("#data2").css("display","none");
  	       $("#data5").css("display","none");
  	        });
</script>
<%
}
else if(b!=null&&b.equals("5")){
 %>
 <script type="text/javascript">
    $(document).ready(function(){
  $("#data5").css("display","block");
    $("#data1").css("display","none");
  	     $("#data3").css("display","none");
  	      $("#data4").css("display","none");
  	       $("#data2").css("display","none");
  	         });
</script>
<%
}
session.removeAttribute("page");
%>

<div id="data1">
 <ul class="nav nav-tabs nav-justified">
  <li role="presentation"><a>学生学号</a></li>
   <li role="presentation"><a >学生姓名</a></li>
    <li role="presentation"><a >学生性别</a></li>
     <li role="presentation"><a>学生年龄</a></li>
      <li role="presentation"><a >学生地址</a></li>
        <li role="presentation"><a >学生专业</a></li>
          <li role="presentation"><a >学生班级</a></li>
            <li role="presentation"><a >学生学分</a></li>
            </ul>
  <table class="table">
     <% ArrayList<MSBean> s=(ArrayList<MSBean>)session.getAttribute("student");%>
     <%for(int i=0;i<s.size();i++){
     %>
  <tr><td align="middle"><span class="label label-info"><%=s.get(i).getSno() %></span></td>
  <td align="middle"><span class="label label-info"><%=s.get(i).getSname() %></span></td>
  <td align="middle"><span class="label label-info"><%=s.get(i).getSsex() %></span></td>
  <td align="middle"><span class="label label-info"><%=s.get(i).getSage() %></span></td>
  <td align="middle"><span class="label label-info"><%=s.get(i).getSaddr() %></span></td>
  <td align="middle"><span class="label label-info"><%=s.get(i).getMname() %></span></td>
  <td align="middle"><span class="label label-info"><%=s.get(i).getGno() %></span></td>
  <td align="middle"><span class="label label-info"><%=s.get(i).getScredit()%></span></td></tr>
  <%
  }
  %>
  </table>  <!-- ******************************* -->
  <table class="table">
 <form action="/SAMS/AddStudent" method="post">
<tr>
 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="学生学号" name="sno" aria-describedby="basic-addon1">
</div>
</td>

 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="学生姓名" name="sname" aria-describedby="basic-addon1">
</div>
</td>

 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="学生性别" name="ssex" aria-describedby="basic-addon1">
</div>
</td>

 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="学生年龄" name="sage" aria-describedby="basic-addon1">
</div>
</td>
 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="学生地址" name="saddr" aria-describedby="basic-addon1">
</div>
</td>
 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="学生班级" name="sclass" aria-describedby="basic-addon1">
</div>
</td>
</tr>


 <tr><td colspan="8" align="middle" ><button class="btn btn-default" type="submit">提交</button></td></tr>
  <%
String a=(String)session.getAttribute("success");%>

<%
if(a!=null&&a.equals("0")){
%>
<script type="text/javascript">
alert("提交失败");
</script>
<%
session.removeAttribute("success");
}
if(a!=null&&a.equals("1")){
 %>
 <script type="text/javascript">
alert("提交成功");
</script>
<%session.removeAttribute("success");
}
 %>
 </form>

  </table>
  
  </div>
  
  <div id="data2">
  <ul class="nav nav-tabs nav-justified">
  <li role="presentation"><a>教师编号</a></li>
  <li role="presentation"><a >教师姓名</a></li>
  <li role="presentation"><a >教师性别</a></li>
    <li role="presentation"><a>教师年龄</a></li>
      <li role="presentation"><a >教师职称</a></li>
        <li role="presentation"><a >教师电话</a></li>
            </ul>
              <table class="table"  >
  <% ArrayList<TeacherBean> t=(ArrayList<TeacherBean>)session.getAttribute("teacher");%>
     <%for(int i=0;i<t.size();i++){
     %>
<tr><td align="middle"><span class="label label-info"><%=t.get(i).getTno() %></span></td>
<td align="middle"><span class="label label-info"><%=t.get(i).getTname() %></span></td>
<td align="middle"><span class="label label-info"><%=t.get(i).getTsex() %></span></td>
<td align="middle"><span class="label label-info"><%=t.get(i).getTage() %></span></td>
<td align="middle"><span class="label label-info"><%=t.get(i).getTtitle() %></span></td>
<td align="middle"><span class="label label-info"><%=t.get(i).getTtel() %></span></td></tr>
<%
}
 %>
<form action="/SAMS/AddTeacher" method="post">
<tr>
 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="教师编号" name="tno" aria-describedby="basic-addon1">
</div>
</td>

 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="教师姓名" name="tname" aria-describedby="basic-addon1">
</div>
</td>

 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="教师性别" name="tsex" aria-describedby="basic-addon1">
</div>
</td>

 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="教师年龄" name="tage" aria-describedby="basic-addon1">
</div>
</td>
 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="教师职称" name="ttitle" aria-describedby="basic-addon1">
</div>
</td>
 <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="教师电话" name="ttel" aria-describedby="basic-addon1">
</div>
</td>

  <tr><td colspan="6" align="middle"><button class="btn btn-default" type="submit">提交</button></td></tr>
  <%
 a=(String)session.getAttribute("success");
if(a!=null&&a.equals("0")){
%>
<script type="text/javascript">
alert("提交失败");
</script>
<%
session.removeAttribute("success");
}
if(a!=null&&a.equals("1")){
 %>
 <script type="text/javascript">
alert("提交成功");
</script>
<%session.removeAttribute("success");
}
 %>
  </form>
  
  </table>
  
  </div>
  
  
  <div id="data3">
  <ul class="nav nav-tabs nav-justified">
  <li role="presentation"><a>课程编号</a></li>
  <li role="presentation"><a >课程名称</a></li>
  <li role="presentation"><a >课程类型</a></li>
   <li role="presentation"><a>任课教师</a></li>
    <li role="presentation"><a>课程学分</a></li>
      <li role="presentation"><a >课程学时</a></li>
            </ul>
              <table class="table"  >
  <% ArrayList<CATBean> c=(ArrayList<CATBean>)session.getAttribute("course");%>
     <%for(int i=0;i<c.size();i++){
     %>
<tr><td align="middle"><span class="label label-info"><%=c.get(i).getCno() %></span></td>
<td align="middle"><span class="label label-info"><%=c.get(i).getCname() %></span></td>
<td align="middle"><span class="label label-info"><%=c.get(i).getCtype() %></span></td>
<td align="middle"><span class="label label-info"><%=c.get(i).getTname() %></span></td>
<td align="middle"><span class="label label-info"><%=c.get(i).getCredits() %></span></td>
<td align="middle"><span class="label label-info"><%=c.get(i).getCperiod() %></span></td></tr>
<%
}
 %>
  <form action="/SAMS/AddCourse" method="post">
<tr>
<td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="课程编号" name="cno" aria-describedby="basic-addon1">
</div>
</td>

<td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="课程名称" name="cname" aria-describedby="basic-addon1">
</div>
</td>

<td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="课程类型" name="ctype" aria-describedby="basic-addon1">
</div>
</td>

<td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="教师编号" name="cteacher" aria-describedby="basic-addon1">
</div>
</td>

<td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="课程学分" name="credits" aria-describedby="basic-addon1">
</div>
</td>

<td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="课程学时" nmae="cperiod" aria-describedby="basic-addon1">
</div>
</td>
  
  <tr><td colspan="6" align="middle"><button class="btn btn-default" type="submit">提交</button></td></tr>
  <%
 a=(String)session.getAttribute("success");
if(a!=null&&a.equals("0")){
%>
<script type="text/javascript">
alert("提交失败");
</script>
<%
session.removeAttribute("success");
}
if(a!=null&&a.equals("1")){
 %>
 <script type="text/javascript">
alert("提交成功");
</script>
<%session.removeAttribute("success");
}
 %>
  </form>
  
  </table>
  
  </div>
  
  <div id="data4">
  <ul class="nav nav-tabs nav-justified">
  <li role="presentation"><a>专业编号</a></li>
  <li role="presentation"><a >班级编号</a></li>
  <li role="presentation"><a >班级名称</a></li>
            </ul>
              <table class="table"  >
 <% ArrayList<ClassBean> h=(ArrayList<ClassBean>)session.getAttribute("class");%>
     <%for(int i=0;i<h.size();i++){
     %>
<tr><td align="middle"><span class="label label-info"><%=h.get(i).getMno() %></span></td>
<td align="middle"><span class="label label-info"><%=h.get(i).getGno() %></span></td>
<td align="middle"><span class="label label-info"><%=h.get(i).getGname() %></span></td></tr>
<%} %>
<form action="/SAMS/AddClass" method="post">
<tr>
<td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="专业编号" name="gmno" aria-describedby="basic-addon1">
</div>
</td>
<td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="班级编号" name="gno" aria-describedby="basic-addon1">
</div>
</td>
  <td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="班级名称" name="gname" aria-describedby="basic-addon1">
</div>
</td>
</tr>
  
  <tr><td colspan="3" align="middle"><button class="btn btn-default" type="submit">提交</button></td></tr>
  <%
 a=(String)session.getAttribute("success");
if(a!=null&&a.equals("0")){
%>
<script type="text/javascript">
alert("提交失败");
</script>
<%
session.removeAttribute("success");
}
if(a!=null&&a.equals("1")){
 %>
 <script type="text/javascript">
alert("提交成功");
</script>
<%session.removeAttribute("success");
}
 %>
  </form>
  
  </table>
  
  </div>
  
    <div id="data5">
  <ul class="nav nav-tabs nav-justified">
  <li role="presentation"><a>专业编号</a></li>
  <li role="presentation"><a >专业名称</a></li>
            </ul>
              <table class="table"  >
 <% ArrayList<MajorBean> m=(ArrayList<MajorBean>)session.getAttribute("major");%>
     <%for(int i=0;i<m.size();i++){
     %>
<tr><td align="middle"><span class="label label-info"><%=m.get(i).getMno() %></span></td>
<td align="middle"><span class="label label-info"><%=m.get(i).getMname() %></span></td></tr>
<%} %>
<form action="/SAMS/AddMajor" method="post">
<tr>
<td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="专业编号" name="mno" aria-describedby="basic-addon1">
</div>
</td>
<td align="center">
<div class="input-group">
  <input type="text" class="form-control" placeholder="专业名称"  name="mname" aria-describedby="basic-addon1">
</div>
</td>
</tr>
  
  <tr><td colspan="2" align="middle"><button class="btn btn-default" type="submit">提交</button></td></tr>
   <%
 a=(String)session.getAttribute("success");
if(a!=null&&a.equals("0")){
%>
<script type="text/javascript">
alert("提交失败");
</script>
<%
session.removeAttribute("success");
}
if(a!=null&&a.equals("1")){
session.removeAttribute("success");
 %>
 <script type="text/javascript">
alert("提交成功");
</script>
<%
}
 %>
  </form>
  </table>
  </div>
  
  <div align="center">
  <input type="button" value="返回主页" onclick=jump() class="btn btn-primary">
  </div>
     
      <script>
       $(document).ready(function(){
  	   $("#one").click(function(){
  	     $("#data1").css("display","block");
  	     $("#data2").css("display","none");
  	     $("#data3").css("display","none");
  	      $("#data4").css("display","none");
  	       $("#data5").css("display","none");
       });
        $("#two").click(function(){
  	     $("#data2").css("display","block");
  	     $("#data1").css("display","none"); 
  	     $("#data3").css("display","none");
  	      $("#data4").css("display","none");
  	       $("#data5").css("display","none");
       });
       $("#three").click(function(){
  	     $("#data3").css("display","block");
  	     $("#data1").css("display","none"); 
  	     $("#data2").css("display","none");
  	      $("#data4").css("display","none");
  	       $("#data5").css("display","none");
       });
        $("#four").click(function(){
  	     $("#data4").css("display","block");
  	     $("#data1").css("display","none"); 
  	     $("#data2").css("display","none");
  	      $("#data3").css("display","none");
  	        $("#data5").css("display","none");
       });
        $("#five").click(function(){
  	     $("#data5").css("display","block");
  	     $("#data1").css("display","none"); 
  	     $("#data2").css("display","none");
  	      $("#data3").css("display","none");
  	       $("#data4").css("display","none");
       });
     });
      </script>
      
  </body>
</html>

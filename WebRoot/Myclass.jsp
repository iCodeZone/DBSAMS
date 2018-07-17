<%@ page language="java" import="java.util.*,Bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的课程</title>
 <link rel="stylesheet" href="BootStrap/bootstrap.css">
    <link rel="stylesheet" href="BootStrap/3.3.7/css/bootstrap.min.css">
      <link rel="stylesheet" href="BootStrap/3.3.7/bootstrap.min.js">

<style type="text/css">
body{
    background-image:url(5.jpg);
    background-size: 100% 100%;
    }
</style>
  </head>
  <body>
  <script>
function jump(){
window.location.href="index.jsp";
}
</script>
  <% ArrayList<CATBean> courses=(ArrayList<CATBean>)session.getAttribute("courses");
  %>
  <div class="page-header">
  <h1><span class="label label-primary">课程信息</span></h1>
</div>

  <table class="table">
 <tr><td align="center"><span class="label label-info">课程名称</span></td>
 <td align="center"><span class="label label-info">课程类型</span></td>
 <td align="center"><span class="label label-info">课程学分</span></td>
 <td align="center"><span class="label label-info">课程学时</span></td>
 <td align="center"><span class="label label-info">课程时间</span></td>
 <td align="center"><span class="label label-info">任课老师</span></td>
 <td align="center"><span class="label label-info">课程成绩</span></td></tr>
<%for(int i=0;i<courses.size();i++){
%>
 <tr><td align="center"><span class="label label-default"><%=courses.get(i).getCname()%></span></td>
 <td align="center"><span class="label label-default"><%=courses.get(i).getCtype()%></span></td>
 <td align="center"><span class="label label-default"><%=courses.get(i).getCredits()%></span></td>
 <td align="center"><span class="label label-default"><%=courses.get(i).getCperiod() %></span></td>
 <td align="center"><span class="label label-default"><%=courses.get(i).getRterm()%></span></td>
 <td align="center"><span class="label label-default"><%=courses.get(i).getTname() %></span></td>
 <td align="center"><span class="label label-default"><%=courses.get(i).getGrade()  %></span></td></tr>
<%
}
 %>
 <tr><td colspan="7" align="middle"><input type="button" value="返回主页" onclick=jump() class="btn btn-primary"></td></tr>
 </table>
    <script src="BootStrap/jquery-3.3.1.js"></script>
     <script src="BootStrap/bootstrap.js"></script>
     
  </body>
</html>

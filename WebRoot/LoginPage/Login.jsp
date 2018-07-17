<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
  <head>  
  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../BootStrap/bootstrap.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.css">
    <title>成绩信息管理系统</title>

    <style type="text/css">
    .btn { 
          width:318px;
         }
    #group{
           margin-bottom:5px;
          }
    #container{
               margin-top:30px;
               margin-left:100px;
               width:1200px;
              }
    #zhushi{
            display:flex;
            justify-content:center;
            align-items:flex-end;
            margin-top:20px;
           }
    #form-control{
                  width:280px;
                 }

    </style>

 
  </head>
  
  <body>
  
     <%String success=(String)session.getAttribute("success"); %>
     <%if(success!=null && success.equals("0")){
     	 session.removeAttribute("success");
     %>
         <script>
         alert("账号或密码错误！");
         </script>    
     <%}%>
  
     <div class="input-group">
       <h1>
         <span class="glyphicon glyphicon-education"></span>
         <em>成绩信息管理系统</em>
       </h1>
     </div>
     
     
     
     <div class="container-fluid row panel panel-default" id="container">
     
     <div class="col-xs-10 col-sm-6 col-md-8" style="margin-bottom:20px;">
        <img src="../Picture/1.jpg" width='750px' height='480px'>
     </div>
     
     <div class="col-xs-10 col-sm-6 col-md-4 panel panel-default" style="width:350px;">
     <strong>用户登录</strong>
     
     <form class="form-inline" action="/SAMS/Login" method="post">
     
      <div id="group">
        <div class="input-group">
          <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
          <div><input type="text" class="form-control" id="form-control" name="username" placeholder="用户名"></div>
        </div><br/>
      </div>
     
      <div id="group">
        <div class="input-group">
          <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
          <div><input type="text" class="form-control" id="form-control" name="password" placeholder="密码"></div>
        </div>
      </div>
        
      <div id="group">
        <div class="input-group">
          <div class="input-group-addon"><span class="glyphicon glyphicon-tag"></span></div>
            <div>
              <select class="form-control" name="type" style="width:120px;">
                <option value='3'>学生</option>
                <option value='2'>教师</option>
                <option value='1'>管理员</option>
              </select>
            </div>
          </div>
        </div>
     
     
     <br/>
     <button class="btn btn-primary">登录</button>
     </form>
     
     <div class="bg-info " style="margin-bottom:50px;">
        <font>初次登录时，密码默认为123456</font><br>
        <font>忘记密码可拨打xxxx-xxxx进行重置</font>
     </div>

    
    </div>
      
     
      <div>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="width:350px;">
                     点击查看相关条款
        </button>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="myModalLabel">隐私条款</h4>
              </div>
            <div class="modal-body">
                                      翻版必究！！！
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal" style="width:150px;">Close</button>
              <button type="button" class="btn btn-primary" style="width:150px;">Save changes</button>
            </div>
          </div>
        </div>
      </div>
     
     
     
     </div>
     
    </div>

    <div id="zhushi"><small>版权所有 翻版必究© 浙江工业大学屏峰校区·郭盛 </small></div>
      
   
       
     <script src="../BootStrap/jquery-3.3.1.js"></script>
     <script src="../BootStrap/bootstrap.js"></script>

  </body>
</html>

    

     $(document).ready(function(){            //个人信息点击事件
    	 $("#one").click(function(){
    		 location.href="Message.jsp"
         });
         
         $("#grxx1").click(function(){          //基本资料点击事件
        	 location.href="BasicMessage.jsp";
         });
         
         $("#grxx2").click(function(){          //密码管理点击事件
        	 location.href="AlterPassword.jsp";
         });
       
       $("#first").click(function(){  //查看课程点击事件
    	   //location.href="SubjectPage.jsp";
  	       var pn = $(this).attr("name");
  	       location.href = "/SAMS/TClass?date="+pn+"&page=1";//location.href实现客户端页面的跳转
       });
       
       $("#second").click(function(){         //查看课程点击事件
    	   //location.href="SubjectPage.jsp";
  	       var pn = $(this).attr("name");
	       location.href = "/SAMS/TClass?date="+pn+"&page=1";//location.href实现客户端页面的跳转
       });
       
       $("#third").click(function(){          //查看课程点击事件
    	   //location.href="SubjectPage.jsp";
  	       var pn = $(this).attr("name");
	       location.href = "/SAMS/TClass?date="+pn+"&page=1";//location.href实现客户端页面的跳转
       });
       
       $("#four").click(function(){           //查看课程点击事件
    	   //location.href="SubjectPage.jsp";
  	       var pn = $(this).attr("name");
	       location.href = "/SAMS/TClass?date="+pn+"&page=1";//location.href实现客户端页面的跳转
       });
       
       $("#five").click(function(){           //成绩录入点击事件
    	   var pn = $(this).attr("name");
	       location.href = "/SAMS/TClass?date="+pn+"&page=2";//location.href实现客户端页面的跳转
    	   //location.href ="ScorePage.jsp;";
       });
       
       $("#six").click(function(){            //成绩录入点击事件
    	   var pn = $(this).attr("name");
	       location.href = "/SAMS/TClass?date="+pn+"&page=2";//location.href实现客户端页面的跳转
    	   //location.href ="ScorePage.jsp;";
       });
       
       $("#seven").click(function(){          //成绩录入点击事件
    	   var pn = $(this).attr("name");
	       location.href = "/SAMS/TClass?date="+pn+"&page=2";//location.href实现客户端页面的跳转
    	   //location.href ="ScorePage.jsp;";
       });
       
       $("#eight").click(function(){          //成绩录入点击事件
    	   var pn = $(this).attr("name");
	       location.href = "/SAMS/TClass?date="+pn+"&page=2";//location.href实现客户端页面的跳转
    	   //location.href ="ScorePage.jsp;";
       });
       
       $(".pict").click(function(){           //课程图片点击事件
    	   var pn=$(this).attr("name");
    	   location.href = "/SAMS/MClass?num="+pn+"&page=1";
    	   //location.href="SubjectMessage.jsp";
       });       
     });
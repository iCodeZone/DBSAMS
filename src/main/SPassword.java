package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.StudentDao;

public class SPassword extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String oldpassword = (String)request.getParameter("oldpassword");
		String newpassword = (String)request.getParameter("newpassword");
		HttpSession session = request.getSession();
		String sno = (String)session.getAttribute("sno");
		//StudentDao student = new StudentDao();
		//out.print("<html><body>");
		if(new StudentDao().AlterPassword(sno, oldpassword, newpassword)){
			session.setAttribute("success", "1");
			//out.print("<h1>修改成功</h1>");
		}
		else{
			session.setAttribute("success", "0");
			//out.print("<h1>修改失败</h1>");
		}
		//out.print("<a href=\"index.jsp\"> 点击返回</a>");
		//out.print("</body></html>");
		//student.Release();
		response.sendRedirect("index.jsp");
	}


}

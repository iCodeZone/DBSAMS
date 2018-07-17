package main.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ClassBean;
import Bean.MajorBean;
import DB.AdminDao;

public class CheckMajor extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		/*request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String mno = request.getParameter("mno");
		if( new AdminDao().deleteMajor(mno)){
			session.setAttribute("delete", "1");
		}
		else{
			session.setAttribute("delete", "0");
		}
		session.setAttribute("page", "5");
		response.sendRedirect("select.jsp");*/
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String mno = request.getParameter("mno");
		MajorBean major = new AdminDao().CheckMajor(mno);
		HttpSession session = request.getSession();
		session.setAttribute("major1", major);
		session.setAttribute("page", "5");
		response.sendRedirect("select.jsp");
	}


}

package main.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.CATBean;
import Bean.ClassBean;
import Bean.CourseBean;
import DB.AdminDao;

public class CheckCourse extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String cno = request.getParameter("cno");
		if( new AdminDao().deleteCourse(cno)){
			session.setAttribute("delete", "1");
		}
		else{
			session.setAttribute("delete", "0");
		}
		session.setAttribute("page", "3");
		response.sendRedirect("select.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String cno = request.getParameter("cno");
		CATBean course = new AdminDao().CheckCourse(cno);
		HttpSession session = request.getSession();
		session.setAttribute("course1", course);
		session.setAttribute("page", "3");
		response.sendRedirect("select.jsp");
	}


}

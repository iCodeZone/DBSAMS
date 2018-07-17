package main.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ClassBean;
import Bean.TeacherBean;
import DB.AdminDao;

public class CheckTeacher extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String tno = request.getParameter("tno");
		if( new AdminDao().deleteTeacher(tno)){
			session.setAttribute("delete", "1");
		}
		else{
			session.setAttribute("delete", "0");
		}
		session.setAttribute("page", "2");
		response.sendRedirect("select.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String tno = request.getParameter("tno");
		TeacherBean teacher = new AdminDao().CheckTeacher(tno);
		HttpSession session = request.getSession();
		session.setAttribute("teacher1", teacher);
		session.setAttribute("page", "2");
		response.sendRedirect("select.jsp");
	}


}

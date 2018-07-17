package main.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ClassBean;
import Bean.MSBean;
import Bean.StudentBean;
import DB.AdminDao;

public class CheckStudent extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String sno = request.getParameter("sno");
		if( new AdminDao().deleteStudent(sno)){
			session.setAttribute("delete", "1");
		}
		else{
			session.setAttribute("delete", "0");
		}
		session.setAttribute("page", "1");
		response.sendRedirect("select.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String sno = request.getParameter("sno");
		MSBean student = new AdminDao().CheckStudent(sno);
		HttpSession session = request.getSession();
		session.setAttribute("student1", student);
		session.setAttribute("page", "1");
		response.sendRedirect("select.jsp");
	}



}

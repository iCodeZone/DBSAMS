package main.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ClassBean;
import DB.AdminDao;

public class CheckClass extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		/*request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String gno = request.getParameter("gno");
		if( new AdminDao().deleteClass(gno)){
			session.setAttribute("delete", "1");
		}
		else{
			session.setAttribute("delete", "0");
		}
		session.setAttribute("page", "3");
		response.sendRedirect("select.jsp");*/
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String gno = request.getParameter("gno");
		ClassBean cclass = new AdminDao().CheckClass(gno);
		HttpSession session = request.getSession();
		session.setAttribute("class1", cclass);
		session.setAttribute("page", "4");
		response.sendRedirect("select.jsp");
	}

}

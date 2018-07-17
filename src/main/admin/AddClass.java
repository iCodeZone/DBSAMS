package main.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ClassBean;
import Bean.CourseBean;
import DB.AdminDao;

public class AddClass extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String gmno = request.getParameter("gmno");
		String gno = request.getParameter("gno");
		String gname = request.getParameter("gname");
		ClassBean c = new ClassBean();
		c.setMno(gmno);
		c.setGno(gno);
		c.setGname(gname);
		session.setAttribute("page", "4");
		if(new AdminDao().AddClass(gno,gname,gmno)){
			ArrayList<ClassBean> cclass = (ArrayList<ClassBean>)session.getAttribute("class");
			cclass.add(c);
			session.setAttribute("class", cclass);
			session.setAttribute("success", "1");
		}
		else{
			session.setAttribute("success", "0");
		}
		response.sendRedirect("luru.jsp");
	}

}

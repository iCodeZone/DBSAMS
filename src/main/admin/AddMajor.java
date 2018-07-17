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
import Bean.MajorBean;
import DB.AdminDao;

public class AddMajor extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String mno = request.getParameter("mno");
		String mname = request.getParameter("mname");
		MajorBean m = new MajorBean();
		m.setMno(mno);
		m.setMname(mname);
		session.setAttribute("page", "5");
		if(new AdminDao().AddMajor(mno, mname)){
			ArrayList<MajorBean> major = (ArrayList<MajorBean>)session.getAttribute("major");
			major.add(m);
			session.setAttribute("major", major);
			session.setAttribute("success", "1");
		}
		else{
			session.setAttribute("success", "0");
		}
		response.sendRedirect("luru.jsp");
	}

}

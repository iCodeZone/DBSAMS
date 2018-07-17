package main.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.*;
import DB.AdminDao;

public class AddStudent extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		String sage = request.getParameter("sage");
		String saddr = request.getParameter("saddr");
		//String mname = request.getParameter("mname");
		String sclass = request.getParameter("sclass");
/*		System.out.println(sno);
		System.out.println(sname);
		System.out.println(ssex);
		System.out.println(sage);
		System.out.println(saddr);
		System.out.println(mname);
		System.out.println(sclass);*/
		MSBean m = new MSBean();
		m.setSno(sno);
		m.setSname(sname);
		m.setSsex(ssex);
		m.setSage(Integer.parseInt(sage));
		m.setSaddr(saddr);
		//m.setMname(mname);
		m.setGno(sclass);
		
		session.setAttribute("page", "1");
		
		if(new AdminDao().AddStudent(m)){
			ArrayList<MSBean> student = new AdminDao().CheckStudent();
			session.setAttribute("student", student);
			session.setAttribute("success", "1");
		}
		else{
			session.setAttribute("success", "0");
		}
		
		response.sendRedirect("luru.jsp");
	}

}

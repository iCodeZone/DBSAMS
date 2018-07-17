package main.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.CATBean;
import Bean.CourseBean;
import Bean.TeacherBean;
import DB.AdminDao;

public class AddCourse extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String ctype = request.getParameter("ctype");
		String credits = request.getParameter("credits");
		String cperiod = request.getParameter("cperiod");
		String cteacher = request.getParameter("cteacher");
		CATBean c = new CATBean();
		c.setCno(cno);
		c.setCname(cname);
		c.setCtype(ctype);
		c.setCredits(Double.parseDouble(credits));
		c.setCperiod(Double.parseDouble(cperiod));
		c.setTno(cteacher);
		session.setAttribute("page", "3");
		if(new AdminDao().AddCourse(c)){
			ArrayList<CATBean> course = new AdminDao().CheckCourse();
			session.setAttribute("course", course);
			session.setAttribute("success", "1");
		}
		else{
			session.setAttribute("success", "0");
		}
		response.sendRedirect("luru.jsp");
		
	}

}

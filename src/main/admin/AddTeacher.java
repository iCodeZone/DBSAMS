package main.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.TeacherBean;
import DB.AdminDao;

public class AddTeacher extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String tno = request.getParameter("tno");
		String tname = request.getParameter("tname");
		String tsex = request.getParameter("tsex");
		String tage = request.getParameter("tage");
		String ttitle = request.getParameter("ttitle");
		String ttel = request.getParameter("ttel");
		TeacherBean t = new TeacherBean();
		t.setTno(tno);
		t.setTname(tname);
		t.setTsex(tsex);
		t.setTage(Integer.parseInt(tage));
		t.setTtitle(ttitle);
		t.setTtel(Long.parseLong(ttel));
		session.setAttribute("page", "2");
		if(new AdminDao().AddTeacher(t)){
			ArrayList<TeacherBean> teacher = (ArrayList<TeacherBean>)session.getAttribute("teacher");
			teacher.add(t);
			session.setAttribute("teacher", teacher);
			session.setAttribute("success", "1");
		}
		else{
			session.setAttribute("success", "0");
		}
		response.sendRedirect("luru.jsp");
	}

}

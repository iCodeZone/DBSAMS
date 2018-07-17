package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.StudentDao;

public class SGrade extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		System.out.println("get");
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

//		System.out.println("post");
		request.setCharacterEncoding("UTF-8");
		String date = (String)request.getParameter("action");
//		System.out.println("action");
		//StudentDao stu = new StudentDao();
		HttpSession session = request.getSession();
		String sno = (String)session.getAttribute("sno");
		session.setAttribute("courses", new StudentDao().getCourse(sno, date));
		//stu.Release();
		//System.out.println("ok");
		//RequestDispatcher rd = request.getRequestDispatcher("Myclass.jsp");
		//rd.forward(request, response);
		response.sendRedirect("Myclass.jsp");
		
	}


}

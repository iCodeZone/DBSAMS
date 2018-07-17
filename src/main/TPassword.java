package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.TeacherDao;

public class TPassword extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		HttpSession session = request.getSession();
		String tno = (String)session.getAttribute("tno");
		//TeacherDao t = new TeacherDao();\
//		System.out.println(password);
//		System.out.println(newpassword);
//		System.out.println(tno);
		if(new TeacherDao().AlterPassword(tno, password, newpassword)){
			session.setAttribute("successpassword", "1");
		}
		else session.setAttribute("successpassword", "0");
		//RequestDispatcher rd = request.getRequestDispatcher("TeacherPage/TeacherPage.jsp");
		//rd.forward(request, response);
		response.sendRedirect("TeacherPage/AlterPassword.jsp");
	}


}

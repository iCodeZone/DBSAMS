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

public class TClass extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String s = request.getParameter("page");
		int num = Integer.parseInt(s);
		String date = request.getParameter("date");
		HttpSession session = request.getSession();
		String tno = (String)session.getAttribute("tno");
		session.setAttribute("date", date);
		//TeacherDao t = new TeacherDao();
		session.setAttribute("classes", new TeacherDao().getCourseInfo(tno, date));
		//t.Release();
		//request.setAttribute("divide", "1");
		String addr;
		if(num==1){
			addr="TeacherPage/SubjectPage.jsp";
		}
		else {
			addr="TeacherPage/ScorePage.jsp";
		}
		//RequestDispatcher rd = request.getRequestDispatcher(addr);
		//rd.forward(request, response);
		response.sendRedirect(addr);
	}

}

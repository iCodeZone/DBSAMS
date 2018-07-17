package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.CourseBean;
import Bean.MemberBean;
import DB.TeacherDao;

public class MClass extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String s = request.getParameter("num");
		int num = Integer.parseInt(s);
		CourseBean course;
		HttpSession session = request.getSession();
		course = ((ArrayList<CourseBean>)session.getAttribute("classes")).get(num-1);
		String tno = (String)session.getAttribute("tno");
		String date = (String)session.getAttribute("date");
		String page = request.getParameter("page");
		//TeacherDao t = new TeacherDao();
		session.setAttribute("member", new TeacherDao().getMember(tno, course.getCno(), date));
		//t.Release();
		session.setAttribute("cno", course.getCno());
		session.setAttribute("kcname", course.getCname());
		//request.setAttribute("divide", 2);
		String addr;
		if(page.equalsIgnoreCase("1")){
			addr="TeacherPage/SubjectMessage.jsp";
		}
		else {
			addr="TeacherPage/ScoreMessage.jsp";
		}
		//RequestDispatcher rd = request.getRequestDispatcher(addr);
		//rd.forward(request, response);
		response.sendRedirect(addr);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ArrayList<MemberBean> arry  = (ArrayList<MemberBean>)session.getAttribute("member");
		double [] grade = new double[arry.size()];
		for(int i=0;i<arry.size();i++){
			String s = request.getParameter(new Integer(i).toString());
			grade[i] = Double.parseDouble(s);
		}
		String tno = (String)session.getAttribute("tno");
		String cno = (String)session.getAttribute("cno");
		String date = (String)session.getAttribute("date");
		//TeacherDao t = new TeacherDao();
		if(new TeacherDao().AlterGrade(arry, grade, cno, tno,date)){
			System.out.println("ok");
		}
		else System.out.println("no");
		//RequestDispatcher rd = request.getRequestDispatcher("TeacherPage/ScorePage.jsp");
		//rd.forward(request, response);
		response.sendRedirect("TeacherPage/ScorePage.jsp");
		
	}


}

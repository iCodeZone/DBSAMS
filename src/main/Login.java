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

import Bean.CATBean;
import Bean.ClassBean;
import Bean.MSBean;
import Bean.MajorBean;
import Bean.TeacherBean;
import DB.*;
import Bean.*;

public class Login extends HttpServlet {
	public void destroy() {
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
/*		System.out.println(username);
		System.out.println(password);
		System.out.println(type);*/
		
		//�Թ���Ա��¼ʱ
		if(type.equals("1")){
			//AdminDao admin = new AdminDao();
			if(new AdminDao().Login(username, password)){
				//admin.Release();    //�ͷ�����
				//request.setAttribute("username", username);  //���Σ�
				//RequestDispatcher rd = request.getRequestDispatcher("");   //������ת·��
				//rd.forward(request, response);
				HttpSession session = request.getSession();
				ArrayList<ClassBean> cclass = new AdminDao().CheckClass();
				ArrayList<CATBean> course = new AdminDao().CheckCourse();
				ArrayList<MajorBean> major = new AdminDao().CheckMajor();
				ArrayList<MSBean> student = new AdminDao().CheckStudent();
				ArrayList<TeacherBean> teacher = new AdminDao().CheckTeacher();
				session.setAttribute("class", cclass);
				session.setAttribute("course", course);
				session.setAttribute("major", major);
				session.setAttribute("student", student);
				session.setAttribute("teacher", teacher);
				
				response.sendRedirect("message.html");
			}
			else {
				//admin.Release();    //�ͷ�����
				//request.setAttribute("success", false);
				//RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");   //��¼ʧ����ת�ص�¼����
				//rd.forward(request, response);
				HttpSession session = request.getSession();
				session.setAttribute("success", "0");
				response.sendRedirect("LoginPage/Login.jsp");
			}
		}
		
		//�Խ�ʦ��¼ʱ
		else if(type.equals("2")){  
//			System.out.println("ok1");
//			TeacherDao teacher = new TeacherDao();
			if(new TeacherDao().Login(username, password)){
//				System.out.println("ok2");
				HttpSession session = request.getSession();
				session.setAttribute("teacher", new TeacherDao().getInfo(username));
				session.setAttribute("tno", username);
				//teacher.Release();    //�ͷ�����
				//request.setAttribute("username", username);
				//RequestDispatcher rd = request.getRequestDispatcher("TeacherPage/TeacherPage.jsp");   //������ת·��
				//rd.forward(request, response);
				response.sendRedirect("TeacherPage/TeacherPage.jsp");
			}
			else {
//				System.out.println("ok3");
				//teacher.Release();    //�ͷ�����
				//request.setAttribute("success", "0");
				HttpSession session = request.getSession();
				session.setAttribute("success", "0");
				//RequestDispatcher rd = request.getRequestDispatcher("LoginPage/Login.jsp");   //��¼ʧ����ת�ص�¼����LoginPage/Login.jsp
				//rd.forward(request, response);
				response.sendRedirect("LoginPage/Login.jsp");
			}
		}
		
		//��ѧ����¼ʱ
		else {                     
			//StudentDao student = new StudentDao();
			if(new StudentDao().Login(username, password)){
				HttpSession session = request.getSession();
				session.setAttribute("student", new StudentDao().getInfo(username));
				session.setAttribute("sno", username);
				//student.Release();    //�ͷ�����
				//RequestDispatcher rd = request.getRequestDispatcher("");   //������ת·��
				//rd.forward(request, response);
				response.sendRedirect("index.jsp");
			}
			else {
				//student.Release();    //�ͷ�����
				//request.setAttribute("success", false);
				//RequestDispatcher rd = request.getRequestDispatcher("LoginPage/Login.jsp");   //��¼ʧ����ת�ص�¼����
				//rd.forward(request, response);
				HttpSession session = request.getSession();
				session.setAttribute("success", "0");
				response.sendRedirect("LoginPage/Login.jsp");
			}
		}
	}

}

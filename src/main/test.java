package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		System.out.println(username);
		System.out.println(password);
		System.out.println(type);
		request.setAttribute("success", "0");
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request,response);
	}


}

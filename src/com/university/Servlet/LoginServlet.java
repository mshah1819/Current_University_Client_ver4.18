package com.university.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.Service.*;
import com.university.bean.RegistrationBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Service service = new Service();
	String[] univInfoNameList, univInfoStateList, univStateList, univBranchList;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			RegistrationBean userName = service.verifyUser(email, password);
			System.out.println("Found user : "+userName.getFirstName());
			if(userName.getFirstName().equals(null)){
				response.sendRedirect("index.jsp");
				return;
			}
			else{
				request.getSession().setAttribute("userName", userName);
				response.sendRedirect("home");
				return;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

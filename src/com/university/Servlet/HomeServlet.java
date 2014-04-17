package com.university.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.university.Service.Service;
import com.university.bean.RegistrationBean;

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Service service = new Service();
	String[] univInfoNameList, univInfoStateList, univStateList, univBranchList;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			univInfoNameList = new String[service.forScriptGetUniversityName().length];
			univInfoNameList = service.forScriptGetUniversityName();

			univStateList = new String[service.forScriptGetStateName().length];
			univStateList = service.forScriptGetStateName();

			univBranchList = new String[service.forScriptGetBranchName().length];
			univBranchList = service.forScriptGetBranchName();

			request.setAttribute("univInfoNameList", univInfoNameList);
			request.setAttribute("univStateList", univStateList);
			request.setAttribute("univBranchList", univBranchList);
 			
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward( request, response); 

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

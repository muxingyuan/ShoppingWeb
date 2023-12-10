package com.pro684.lab03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Lab3 Xingyuan 20231107
 */
@WebServlet("/user")
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public user() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String employeeId = request.getParameter("loginid");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String phone = request.getParameter("age");
		String hireDate = request.getParameter("topic");
		
		//create class "UserDB" and class "User" to handle multiple users
				
		request.getRequestDispatcher("RegisterUser.jsp").forward(request, response);
		//response.sendRedirect("VerificationPage");
		
		
	}

}

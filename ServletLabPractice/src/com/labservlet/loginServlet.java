package com.labservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public loginServlet() {
        super();

    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("code") && password.equals("code1")){
			request.getRequestDispatcher("accessdeny.html").forward(request, response);
		}
		else {
			request.getRequestDispatcher("welcome.html").forward(request, response);
		}
	}

}

package com.class5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletA
 */
//@WebServlet("/ServletA")
public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletA() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		try{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String sessObj = "Mobile";
			out.println("<br/>");
			out.println("Hello "+sessObj);
			
			HttpSession session = request.getSession();
			session.setAttribute("name", sessObj);
			
			Cat cat = new Cat();
			out.println("<br/>" + cat.bark);
			
		} catch(Exception e) {
			System.out.println("Exeption: "+e);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}

package com.class5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletA
 */
//@WebServlet("/ServletB")
public class ServletB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletB() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String item1 = "Mobile";
		String item2 = "Phone";
		request.setAttribute("item1", item1);		
		request.setAttribute("item2", item2);
		
		ServletContext context = getServletContext();
		context.setAttribute("School", "Seneca");
		
		try{
			response.setContentType("text/html");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			PrintWriter out = response.getWriter();
			
			HttpSession session = request.getSession();
            String Uname = (String) session.getAttribute("name");
			out.println("<br/>");
            out.println("Session name: " + Uname);
			

			
		} catch(Exception e) {
			System.out.println("Exception: " + e);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

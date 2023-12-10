package com.pro684.lab02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeRegistrationPage
 * Lab02 Registration Page, Xingyuan 20231017
 */
//@WebServlet("/EmployeeSearchServlet")
public class EmployeeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmployeeSearchServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		try{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String sessObj = "user1";
			String employeeId = request.getParameter("employeeid");
			
			out.println("<br/>");
			out.println("Hello "+sessObj+" !");
			out.println("<br/>");			
			out.println("Search result of EmployeeID: "+employeeId+" will be available soon.");			
			HttpSession session = request.getSession();
			session.setAttribute("name", sessObj);
			session.setAttribute("collection", "add code here handling collection of search terms");
			
		} catch(Exception e) {
			System.out.println("Exeption: "+e);
		}
	}

}

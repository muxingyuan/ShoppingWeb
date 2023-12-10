package com.pro684.lab02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 * Lab2 Xingyuan 20231017
 */
//@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmployeeRegistrationServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String employeeId = request.getParameter("employeeid");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String hireDate = request.getParameter("hiredate");
		String managerId = request.getParameter("managerid");
		String departmentId = request.getParameter("departmentid");
				
		
		if(!validate1(firstName, lastName)){
			errorh(firstName + ", " + lastName);
		}
		if(!validate2(phone, email)){
			errorh(phone + ", " + email);
		}
		if(!validate3(employeeId, hireDate)){
			errorh(employeeId + ", " + hireDate);
		}
		if(!validate3(managerId, departmentId)){
			errorh(managerId + ", " + departmentId);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Employee Details</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Employee Details</h1>");
        out.println("ID:"+employeeId+"</br></br>");
        out.println("First Name:"+firstName+"</br></br>");
        out.println("Last Name:"+lastName+"</br></br>");
        out.println("Email Address:"+email+"</br></br>");
        out.println("Phone:"+phone+"</br></br>");
        out.println("Hire Date:"+hireDate+"</br></br>");
        out.println("Manager ID:"+managerId+"</br></br>");
        out.println("Department ID:"+departmentId+"</br></br>");       
        
        
        out.println("</body>");
        out.println("</html>");
		
	}

	private boolean validate1(String par1, String par2) {
		if(par1.length() < 31 && par1 != null && par2.length() < 31 && par2 != null){
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean validate2(String par1, String par2) {
		if(par1.length() < 50 && par1 != null && par2.length() < 15 && par2 != null){
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean validate3(String par1, String par2) {
		if(par1.length() < 30 && par1 != null && par2.length() < 30 && par2 != null){
			return true;
		}
		else {
			return false;
		}
	}
	
	private void errorh(String str) {
		System.out.println("please correct your input in" + str + "section(s).");
	}
	
}

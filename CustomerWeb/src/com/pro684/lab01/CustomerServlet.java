package com.pro684.lab01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 * Lab1 Xingyuan 20231003
 */
//@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerServlet() {
        super();

    }

/*
	public void init(ServletConfig config) throws ServletException {

	}


	public void destroy() {

	}

*/
    
    //Xingyuan: in reality, will set Private variables and query to database, for now, just use variable inside doPost method.
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String phonetype = request.getParameter("phonetype");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String province = request.getParameter("province");
		String pc = request.getParameter("pc");
		String addresstype = request.getParameter("addresstype");
		String sin = request.getParameter("sin");
		
		
		
		if(!validate1(firstname, lastname)){
			errorh(firstname + ", " + lastname);
		}
		if(!validate2(phone, phonetype)){
			errorh(phone + ", " + phonetype);
		}
		if(!validate3(address, city)){
			errorh(address + ", " + city);
		}
		if(!validate4(province, pc)){
			errorh(province + ", " + pc);
		}
		if(!validate5(addresstype, sin)){
			errorh(addresstype + ", " + sin);
		}
		
		request.getRequestDispatcher("VerificationPage").forward(request, response);
		//response.sendRedirect("VerificationPage");
		
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
		if(par1.length() < 16 && par1 != null && par2 != null){
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean validate3(String par1, String par2) {
		if(par1.length() < 101 && par1 != null && par2.length() < 31 && par2 != null){
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean validate4(String par1, String par2) {
		if(par1.length() < 3 && par1 != null && par2.length() < 7 && par2 != null){
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean validate5(String par1, String par2) {
		if(par1 != null && par2.length() < 10 && par2 != null){
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

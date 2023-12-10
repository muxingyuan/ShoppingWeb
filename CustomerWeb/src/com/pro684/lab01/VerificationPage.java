package com.pro684.lab01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerificationPage
 * Lab01 Verification Page, Xingyuan 20231003
 */
//@WebServlet("/VerificationPage")
public class VerificationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VerificationPage() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Verification Page</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Customer Information Verification</h1>");
        out.println("First Name:"+firstname+"</br></br>");
        out.println("Last Name:"+lastname+"</br></br>");
        out.println("Phone:"+phone+"</br></br>");
        out.println("Phone Type:"+phonetype+"</br></br>");
        out.println("Address:"+address+"</br></br>");
        out.println("City:"+city+"</br></br>");
        out.println("Province:"+province+"</br></br>");
        out.println("Postal Code:"+pc+"</br></br>");
        out.println("Address Type:"+addresstype+"</br></br>");
        out.println("SIN:"+sin+"</br></br>");        
        
        
        out.println("</body>");
        out.println("</html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

package com.labservlet;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HelloWorldServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>hello everyone, how are you? Again?</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

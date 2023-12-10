package com.project.survey;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/SurveyListServlet")
public class SurveyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected final String url = "jdbc:mysql://localhost:3306/surveydb";

    public SurveyListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01" + "Transitional//EN\">\n";
		String title = "Survery List";
		out.print(docType +
				"<HTML>\n" +
				"<BODY><CENTER>\n" +
				"<TABLE CLASS='TITLE' BORDER='5'>" +
				"<TR><TH>" + title + "</TABLE><P>");
		showTable(out);
		out.println("<BR><HR><BR>");
		out.println("</CENTER></BODY></HTML>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

	
	protected void showTable(PrintWriter out) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM vw_Survey";
			ResultSet resultSet = statement.executeQuery(query);
			printTableTop(resultSet, out);
			printTableBody(resultSet, out);
			connection.close();
		}catch(Exception e) {
			System.err.println("Error: " + e);
		}
	}

	
	protected Connection getConnection() throws Exception {
		Connection connection = DriverManager.getConnection(url, "root","admin");
		return(connection);
	}

	
	protected void printTableTop(ResultSet resultSet, PrintWriter out)
	throws SQLException {
		out.println("<TABLE BORDER='1'>");
		String[] headingNames = {"Survey ID", "Survey Name", "Number of Questions", "Number of Answers for each question" };
		out.print("<TR>");
		for (String headingName : headingNames) {
			out.printf("<TH>%s", headingName);
		}
		out.println();
	}
	
	
	protected void printTableBody(ResultSet resultSet, PrintWriter out)
	throws SQLException {
		while(resultSet.next()) {
			out.println("<TR ALIGN='RIGHT'>");
			out.printf("<TD>%d", resultSet.getInt("Survey_id"));
			out.printf("<TD>%s", resultSet.getString("Survey_name"));
			out.printf("<TD>%d", resultSet.getInt("Number_of_questions"));
			out.printf("<TD>%d", resultSet.getInt("Number_of_answers"));
		}
		out.println("</TABLE>");
	}
	
}

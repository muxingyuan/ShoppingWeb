package com.project.survey;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//@WebServlet("/StatServlet")
public class StatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected final String url = "jdbc:mysql://localhost:3306/surveydb";

    public StatServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String surveyIdString = (String) session.getAttribute("s_surveyid");

		
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docType = 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01" + "Transitional//EN\">\n";
		String title = "Under Development: Statistics Survey Id: " + surveyIdString;
		out.print(docType +
				"<HTML>\n" +
				"<BODY><CENTER>\n" +
				"<TABLE CLASS='TITLE' BORDER='5'>" +
				"<TR><TH>" + title + "</TABLE><P>");
		out.print("<FORM action='Statistics' method='post'>\n");
		saveData(surveyIdString);
		showTable(out, surveyIdString);
		out.println("<BR><INPUT type='submit' value='Submit'><BR>");
		out.println("</FORM>");
		out.println("</CENTER></BODY></HTML>");
	}

	protected void saveData(String surveyid) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			
			String queryA = "UPDATE Statistics set Chosen_count = Chosen_count + 1 where survey_id = " + surveyid + " and Question_id = 11" ;
			statement.executeQuery(queryA);
			
			connection.close();
		}catch(Exception e) {
			System.err.println("Error: " + e);
		}
	}


	protected void showTable(PrintWriter out, String surveyid) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			
			String queryA = "SELECT Answer_text FROM vw_SurveyAnswer where Survery_id = 1";
			ResultSet resultSetA = statement.executeQuery(queryA);
			printTableTop(resultSetA, out);
			
			String queryQ = "SELECT Question_id, Question_text FROM vw_SurveyQuestion where Survey_id = 1";
			ResultSet resultSetQ = statement.executeQuery(queryQ);
			printTableBody(resultSetQ, out);

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
		out.println("<TR ALIGN='LEFT'>");
		out.printf("<TH> </TH>");	
		out.printf("<TH> </TH>");
		while(resultSet.next()) {
			out.printf("<TH>%s", resultSet.getString("Answer_text"));
		}

	}
	
	
	protected void printTableBody(ResultSet resultSet, PrintWriter out)
	throws SQLException {
		while(resultSet.next()) {
			out.println("<TR ALIGN='LEFT'>");
			out.printf("<TD>%d", resultSet.getInt("Question_id"));
			out.printf("<TD>%s", resultSet.getString("Question_text"));
			out.printf("<TD>0</TD>");
			out.printf("<TD>0</TD>");		
			out.printf("<TD>0</TD>");
			out.printf("<TD>0</TD>");
			out.printf("<TD>0</TD>");
	    }
		out.println("</TABLE>");
	}
}

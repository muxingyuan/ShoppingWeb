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



//@WebServlet("/SurveyQuestionServlet")
public class SurveyQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
		protected final String url = "jdbc:mysql://localhost:3306/surveydb";

	    public SurveyQuestionServlet() {
	        super();

	    }


		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        String surveyId = request.getParameter("surveyid");
			//Integer answerNumber = 0;
					
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String docType = 
					"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01" + "Transitional//EN\">\n";
			String title = "Questions";
			out.print(docType +
					"<HTML>\n" +
					"<BODY><CENTER>\n" +
					"<TABLE CLASS='TITLE' BORDER='5'>" +
					"<TR><TH>" + title + "</TABLE><P>");
			out.print("<FORM action='StatServlet' method='post'>\n");
			showTable(out, surveyId);
			out.println("<BR><INPUT type='submit' value='Submit'><BR>");
			out.println("</FORM>");
			out.println("</CENTER></BODY></HTML>");
			
	        HttpSession session = request.getSession();
			session.setAttribute("s_surveyid", surveyId);
			//session.setAttribute("s_answerNumber", answerNumber);
		}

		protected void showTable(PrintWriter out, String surveyid) {
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = getConnection();
				Statement statement = connection.createStatement();
				
				String queryA = "SELECT Answer_text FROM vw_SurveyAnswer where Survery_id = " + surveyid;
				ResultSet resultSetA = statement.executeQuery(queryA);
				printTableTop(resultSetA, out);				

				String queryQ = "SELECT Question_id, Question_text FROM vw_SurveyQuestion where Survey_id = " + surveyid;
				ResultSet resultSetQ = statement.executeQuery(queryQ);
				printTableBody(resultSetQ, out);
				
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
				out.printf("<TD><INPUT type='radio' name='" + resultSet.getInt("Question_id") + "' value='1'></TD>");
				out.printf("<TD><INPUT type='radio' name='" + resultSet.getInt("Question_id") + "' value='2'></TD>");
				out.printf("<TD><INPUT type='radio' name='" + resultSet.getInt("Question_id") + "' value='3'></TD>");
				out.printf("<TD><INPUT type='radio' name='" + resultSet.getInt("Question_id") + "' value='4'></TD>");
				out.printf("<TD><INPUT type='radio' name='" + resultSet.getInt("Question_id") + "' value='5'></TD>");
			}
			out.println("</TABLE>");
		}

		
	}
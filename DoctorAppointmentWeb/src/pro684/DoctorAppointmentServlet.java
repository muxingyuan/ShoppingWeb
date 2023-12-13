package pro684;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Servlet implementation class CustomerServlet
 * Final exam Xingyuan 20231212
 */


//@WebServlet("/DoctorAppointmentServlet")
public class DoctorAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DoctorAppointmentServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String patientName = request.getParameter("patientname");
		String patientEmail = request.getParameter("patientemail");
		String patientPhone = request.getParameter("patientphone");
		String doctorName = request.getParameter("doctorname");
			
		PrintWriter out = response.getWriter();
		
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Doctor Appointment Entry Result</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello</h1>");
        
		out.println("Patient Name: "+patientName +"<br/>");
		out.println("Patient Email: "+patientEmail +"<br/>");
		out.println("Patient Phone: "+patientPhone +"<br/>");
		out.println("Doctor Name: "+doctorName +"<br/><br/>");
		
		        
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointmentDB","root","admin");
		Statement insert = con.createStatement();
		insert.executeUpdate("insert into appointment (PatientName, PatientEmail, PatientPhoneNumber, DoctorName) values ('" 
		+ patientName +"','" + patientEmail + "','" + patientPhone + "','" + doctorName + "')");
		System.out.println("appointment successfully booked");
		}catch(Exception e){out.print(e);}
	
        
        out.println("</body>");
        out.println("</html>");
		
	}

}

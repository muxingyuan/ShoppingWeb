package com.class5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RunUtilities {
	
	public static int randomInt(int range){
		return(1 + ((int)(Math.random()*range)));
	}
	
	public static void main(String[] args){
	}
}

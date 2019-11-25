package com.jbk.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//set up connection variable
		String user="root";
		String password="root";
		
		String jdbcurl="jdbc:mysql://localhost:3306/web-customer_schema?useSSL=false";
	    String driver="com.mysql.jdbc.Driver";
	 //get connection  to database
		try {
			PrintWriter out=response.getWriter();
		     out.println("connecting to database: "+jdbcurl);	
		     
		     Class.forName(driver);
		     
		     Connection myconn=DriverManager.getConnection(jdbcurl,user,password);
		     out.println("connection successful!!");
		     
		     myconn.close(); 
		     
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException (e) ;
		}
		
		
	}

}

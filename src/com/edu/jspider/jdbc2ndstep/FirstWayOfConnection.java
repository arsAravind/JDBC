package com.edu.jspider.jdbc2ndstep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FirstWayOfConnection {
	public static void main(String[] args) {
		
		try 
		{
			//step1--->Loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step2----->create the connection
			//getConnection(String dburl); with 1 String argument
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse?user=root&password=root");
			//Have to check that connections happened or not
			
			if(con!=null) //if connection happened in that con(refvar) we will get some string,if not default value will present
			{
				System.out.println("Connection is happened successfully");
			}
			else
			{
				System.out.println("Connection is not happened");
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		} 
		
		//System.out.println("Finish")
	
	}

}

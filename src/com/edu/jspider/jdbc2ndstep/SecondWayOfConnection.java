package com.edu.jspider.jdbc2ndstep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SecondWayOfConnection {
	public static void main(String[] args) {
		try 
		{	
			Class.forName("com.mysql.cj.jdbc.Driver");//1)driver is loaded..
			String dburl="jdbc:mysql://localhost:3306/warehouse?";
			String username="root";
			String pass="root";
			//2)Giving the critical information of DBURL to the Connection(I) refvar...
			//getConnection(String dburl,String username,String password)-3 String Argument
			Connection con=DriverManager.getConnection(dburl,username,pass);
			
			if(con!=null)
			{
				System.out.println("Connection is done");
			}
			else
			{
				System.out.println("Connection is not done");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		

	}

}

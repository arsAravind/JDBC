package com.edu.jspider.querytypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticOtherThanSelectTypeEx2 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String str="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
			Connection con=DriverManager.getConnection(str);
			if(con!=null)
			{
				System.out.println("Connection is done");
			}
			else
			{
				System.out.println("Connection is not done");
			}
			
			String db="update product set yom=2016 where id=9";
			
			Statement stmt=con.createStatement();
			
			int count=stmt.executeUpdate(db);
			
			if(count==0)
			{
				System.out.println("Data insertion is not don");
			}
			else
			{
				System.out.println("Data insertion is done");
			}
			}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

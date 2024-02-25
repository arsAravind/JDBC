package com.edu.jspider.querytypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;

public class DynamicSelectType {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			String query="select * from product where id=?";
			PreparedStatement psmt=con.prepareStatement(query);
			System.out.println("Enter the id value");
			psmt.setInt(1, scn.nextInt());
			ResultSet rs=psmt.executeQuery();
			while(rs.next())
			{
			
				 int id=rs.getInt(1);
				 String phname=rs.getString(2);
				int yom=rs.getInt(3);
				int price=rs.getInt(4);
				int quantity=rs.getInt(5);
				System.out.println(id+" "+phname+" "+yom+" "+price+" "+quantity)	;		
				
				
				/*String name=rs.getString(1);
				System.out.println(name);
				*/
			}	
		}
		catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	}
}

package com.edu.jspider.querytypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicOtherThanSelectTypeEx1 {
	
	public static void main(String[] args)
	{
		Scanner scn=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			if(con==null)
			{
				System.out.println("Connection is not done");
			}
			else
			{
				System.out.println("Connection is done");
			}
			
			String query="insert into product values(?,?,?,?,?)";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1, scn.nextInt());
			psmt.setString(2, scn.next());
			psmt.setInt(3,scn.nextInt());
			psmt.setInt(4, scn.nextInt());
			psmt.setInt(5, scn.nextInt());
			
			int count=psmt.executeUpdate();
			if(count==0)
			{
				System.out.println("Insertion is not done");
			}
			else
			{
				System.out.println("Insertion is done");
				
			}
		} 
		catch (ClassNotFoundException | SQLException e) {	
			e.printStackTrace();
		}
		
	}

}

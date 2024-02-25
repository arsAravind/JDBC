package com.edu.jspider.querytypes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class DynamicOtherThanSelectTypeExplicitly {
	public static void main(String[] args) {
		try 
		{
			//Getting input from user for the placeholder bcoz of dynamictype query
			Scanner scn=new Scanner(System.in);
			
			//1..Loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.Create the connection
			String dburl="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			
			//Connection verification
			if(con!=null)
			{
				System.out.println("Connection is done");
			}
			else
			{
				System.out.println("Connection is not done");
			}
			
			//3...Issue the query
			String query="insert into product values(?,?,?,?,?)";
			
			//4.Create the statement
			PreparedStatement psmt=con.prepareStatement(query);
			
			//After the statement creation we have to insert the value as per user by using setter() method
			//setter method declaration....... public void setInt or setString(int placeholder,value) 
			System.out.println("Enter the id");
			psmt.setInt(1,scn.nextInt());
			System.out.println("Enter the name");
			psmt.setString(2,scn.next());
			System.out.println("Enter the yom");
			psmt.setInt(3,scn.nextInt());
			System.out.println("Enter the price");
			psmt.setInt(4,scn.nextInt());
			System.out.println("Enter the quantity");
			psmt.setInt(5,scn.nextInt());
			
			//5..Execute the query
			int count=psmt.executeUpdate();
			
			//6.Process the query
			if(count==0)
			{
				System.out.println("Insertion is not done");
			}
			else
			{
				System.out.println("insertion is done");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}

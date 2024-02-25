package com.edu.jspider.querytypes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DynamicOtherThanSelectType {
	public static void main(String[] args) {	
		try 
		{
			//1)Loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2)Create the Connection
			String dburl="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			//Verification of connection
			if(con!=null)
			{
				System.out.println("COnnection is done");
			}
			else
			{
				System.out.println("Connection is not done");
			}
			//3)Issue the query
			String query="insert into product values(?,?,?,?,?)";
			//4)Create the statement
			PreparedStatement psmt=con.prepareStatement(query);
			//set the values for placeholder while writing the program
			psmt.setInt(1,11);
			psmt.setString(2,"OPPO");
			psmt.setInt(3,2021);
			psmt.setInt(4, 22000);
			psmt.setInt(5, 3);
			//5)Execute the query
			int count=psmt.executeUpdate();
			//6)Process the query(Verification)
			if(count==0)
			{
				System.out.println("Insertion is not done");
			}
			else
			{
				System.out.println("Insertion is done");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}

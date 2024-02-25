package com.edu.jspider.querytypes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class StaticOtherThanSelectTypeEx1 {
	public static void main(String[] args) {
		try {
			//1)Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2)create the connection
			String dburl="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			
			//Verification of coonnection
			if(con!=null)
			{
				System.out.println("Connection is done");
			}
			else
			{
				System.out.println("Connection is not done");
			}
			
			//3)Issue the query(static other than select)
			String query="insert into product value(7,'realme',30000,2043,2)";
		
			//4)Create the statement depends on querytype
			Statement stmt=con.createStatement();
			
			//5)Execute the query depends on query
			int count=stmt.executeUpdate(query);
			
			//6)process the query
			if(count!=0)
			{
				System.out.println("Insertion is done");
			}
			else
			{
				System.out.println("Insertion is not done");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}



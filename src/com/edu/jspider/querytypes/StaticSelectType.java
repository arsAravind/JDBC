package com.edu.jspider.querytypes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class StaticSelectType {
	public static void main(String[] args) {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			String query="select * from product";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())//next() checking next data present in table
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int yom=rs.getInt(3);
				int price=rs.getInt(4);
				int quantity=rs.getInt(5);
				
				System.out.println(id+" "+name+"  "+yom+"  "+price+"  "+quantity);
			}	
		}
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}	
	}
}

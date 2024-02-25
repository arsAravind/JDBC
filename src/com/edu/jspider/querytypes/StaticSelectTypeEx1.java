package com.edu.jspider.querytypes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class StaticSelectTypeEx1 {
	
	public static void main(String[] args)
	{
		try 
		{
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
			
			String query="select * from product";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())//it will add next data
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int yom=rs.getInt(3);
				int price=rs.getInt(4);
				int quantity=rs.getInt(5);
				System.out.println(id+" "+name+" "+yom+" "+price+" "+quantity);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {	
			e.printStackTrace();
		}
		
	}

}

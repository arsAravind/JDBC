package com.edu.jspider.querytypes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DynamicSelectTypeEx1 
{
	public static void main(String[] args)
		{
			Connection con=null; 
			PreparedStatement psmt=null;
			ResultSet rs=null;
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dburl="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
				con=DriverManager.getConnection(dburl);
				String query="select phname,price from product where yom=?";
				psmt=con.prepareStatement(query);
				psmt.setInt(1, 2020);
				rs=psmt.executeQuery(); //rs---phname  price
										//placeholder    1        2
				if(rs.next())
				{					
					
					int price =rs.getInt(2);
					String name=rs.getString(1);
					System.out.println(name+" "+price);
				}
				else
				{
					System.out.println("Given yom is not present in database");
				}	
			} 
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			finally
			{		
				if(con!=null)
				{
					try
					{
					con.close();
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
				
				if(psmt!=null)
				{
					try {
					psmt.close();
					}
					catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
				if(rs!=null)
				{
					try {
					rs.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
}

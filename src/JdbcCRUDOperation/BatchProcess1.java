package JdbcCRUDOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcess1 {

	public static void main(String[] args) {
		Connection con=null;
		Statement smt=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			if(con==null)
			{
				System.out.println("Connection is not done");
			}
			else
			{
				System.out.println("Connection is done");
			}
			String query1="insert into product values(17,'mi',2015,30000,4)";
			String query2="delete from product where id=2";
			String query3="update product set price=200000 where id=3";
		
			//to add multiple queries at same time
			smt=con.createStatement();
			smt.addBatch(query1);
			smt.addBatch(query2);
			smt.addBatch(query3);
			
			//to execute mutiple queries
			int[] a=smt.executeBatch();
			for(int i:a)
			{
				System.out.println(i);
			}
		} 		
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(smt!=null)
			{
				try {
					smt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
}

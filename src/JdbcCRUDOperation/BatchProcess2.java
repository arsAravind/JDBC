package JdbcCRUDOperation;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
public class BatchProcess2 {
	public static void main(String[] args) {
			Connection con=null;
			Statement smt=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
			 con=DriverManager.getConnection(dburl);
			String query1="update product set quantity=100 where id=1";
			String query2="delete from product where id=3";
			 smt=con.createStatement();
			smt.addBatch(query1);
			smt.addBatch(query2);
			int[] a=smt.executeBatch();//now smt have query1,query2
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
				try
				{
				con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("connection is not done");
			}
			if(smt!=null)
			{
				try {
				smt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}

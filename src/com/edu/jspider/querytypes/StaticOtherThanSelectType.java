package com.edu.jspider.querytypes;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class StaticOtherThanSelectType {
	public static void main(String[] args){
		try {
			//1.Load the driver(pass the driver path)
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Create the connection
			String dburl="jdbc:mysql://localhost:3306/warehouse?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			//Connection verification
			if(con!=null) {
				System.out.println("Connection is happened");
			}
			else {
				System.out.println("Connection is not happened");
			}
			//3.Issue the query
			String query="insert into product values(6,'samsung',40000,2022,30)";
			//4.Create statement depend on Query type
			/*Statement used to carrytransfer the sql queries from java app to rdbms app
			  Statement(I) use to transfer statictype query which is Hardcoding-call createStatement() method
			  PreparedStatement(I) used to transfer th dynamictype query-call prepareStatement() method
			*/
			Statement stmt=con.createStatement();
			
			//5.Execute the query depend on query(select or otherthan select query)
			//Execute the query used to communicate with database
			/*select-exectuteQuery() method returntype is ResultSet
			 * otherthan select(inser,update,delete,drop)-executeUpdate() method return type is int
			 */
			int count=stmt.executeUpdate(query);
			//6.Process the query
			if(count!=0) {
				System.out.println("Inserting the data is done");
			}
			else {
				System.out.println("Insertion is not done");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
}

package JdbcCRUDOperation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class BatchProcess3 {
	public static void main(String[] args){
		Connection con=null;
		Statement smt=null;	
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/studentsdetails?user=root&password=root";
			con=DriverManager.getConnection(dburl);
			String query1="select first_name,marks from student";
			String query2="select * from student where sid=5";
			smt=con.createStatement();
			//smt.addBatch(query1);
			//smt.addBatch(query2);  Wont work..
			ResultSet a=smt.executeQuery(query1);
			System.out.println("1st Query execution");
			System.out.println("--------------------");
			while(a.next()){
				String name=a.getString(1);
				int marks=a.getInt(2);
				System.out.println(name+" "+marks);
			}
			System.out.println("2nd Query execution");
			System.out.println("---------------------");
			ResultSet a1=smt.executeQuery(query2);
			if(a1.next()){
				int id=a1.getInt(1);
				String name=a1.getString(2);
				String name1=a1.getString(3);
				int marks=a1.getInt(4);
				System.out.println("ID\tName\tLastname   Marks");
				System.out.println(id+"\t" +name+"\t  "+name1+"\t"+"   "+marks);			
			}
			else{
				System.out.println("Given id is not present");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
	}
		finally{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(smt!=null){
				try {
					smt.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
		}
	}
}

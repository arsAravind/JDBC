package com.edu.jspider.jdbc1ststep;
//API is the collection of package which help us to communicate or interact b/w 2 app
//JDBC is api used to communicate b/w the java app and RDBMS(MYsql) application
//to make use of JDBC we have to load the Driver(MySQL)
//Driver's(MYSQL driver) are present in form of .jar file which is not having in java libraries
//so we have to first download the .jar file(MySQL connector)from maven repository which is MySQL driver class
//to make use of .jar file(mysql connector) bcoz it contains MySQL Driver class,
//we have to set build path(import) in the project which we downloaded MySQL connector
//now MySQL driver c is ready and then we have to store MySQLdriver in refvar(Driver c of java.sql.Driver)..upcasting
//And by registerDriver(driver//i.e refvar)method and finally we can load the driver(MySQL driver)
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadingTheDriver1stWay {
	public static void main(String[] args) {
		try 
		{			//driver are give it over the (driver) refvariable
			java.sql.Driver driver =new com.mysql.jdbc.Driver();//mySql driver package
			DriverManager.registerDriver(driver);
			System.out.println("loading the driver successfully done..");
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}

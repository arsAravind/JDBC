package com.edu.jspider.jdbc1ststep;

public class LoadingTheDriver2ndWay {

	public static void main(String[] args) {
		try 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Loading the driver 2nd way is done");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}

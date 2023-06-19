package com.bharat.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) 
	{
		String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String username = "hbstudent";
		String password = "hbstudent";
		
		try 
		{
			System.out.println("Connecting to database: " + url);
			
			Connection cn = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connecting successfull!!!");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}


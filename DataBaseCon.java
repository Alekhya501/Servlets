package com.Alekhya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseCon {
	static String  url="jdbc:mysql://localhost:3306/ale";
	static String username="root";
	static String password="1234";
	public static Connection getcon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		return con;
		
	}
	
	
}

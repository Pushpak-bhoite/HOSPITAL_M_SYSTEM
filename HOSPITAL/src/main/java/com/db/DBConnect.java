//this file will return conn object which will provide connection

package com.db;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnect {

	private static Connection conn;

	public static Connection getConn() {  //return type connection and it will return conn 
 
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_2","root","");
		
		 
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
	 return conn;
 }
}

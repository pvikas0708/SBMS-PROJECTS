package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteBooks {
	private static final String DB_URL="jdbc:mysql://localhost:3306/advjavadb";
	private static final String DB_UNAME="root";
	private static final String DB_PWD="root";
	
	public static String DELETE_SQL="update books set book_price=1100 where book_id=100";
	

	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
		System.out.println(con);
		
		Statement stmt=con.createStatement();
		
		int rowEffected =stmt.executeUpdate(DELETE_SQL);
		
		System.out.println("Record Deleted Count ::"+rowEffected);
		con.close();
		

	}
}
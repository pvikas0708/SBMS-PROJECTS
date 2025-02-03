package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateBook {

	private static final String DB_URL="jdbc:mysql://localhost:3306/advjavadb";
	private static final String DB_UNAME="root";
	private static final String DB_PWD="root";
	public static void main(String[] args) throws Exception {
	
	final String UPDATE_SQL="SELECT * FROM BOOKS UPDATE BOOKS SET BOOK_NAME='JAVA COADING' WHERE BOOK_ID=100";
		
		//step 1
		Class.forName("com.mysql.cj.jdbc.Driver"); //to load the class in JVM memory
		
		//step 2
		Connection con=DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD); // to connect DB and JAVA
		System.out.println(con);
		
		//step 3 create a statement
		Statement stmt=con.createStatement(); // to execute DML query
		
		//step 4 execute query
		int rowEffected =stmt.executeUpdate(UPDATE_SQL);
		
		//step 5
		System.out.println("Record Inserted Count ::"+rowEffected);
		
		//step 6
		con.close();

	}

}

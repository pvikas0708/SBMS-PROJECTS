package comselectops;

import java.rmi.ConnectIOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjavadb";
	private static final String DB_USER = "root";
	private static final String DB_PWD = "root";

	private static final String SQL = "INSERT INTO BOOKS VALUES(?,?,?)";

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Book Id::");
		int id = sc.nextInt();

		System.out.println("Enter Book Name::");
		String name = sc.next();

		System.out.println("Enter Book Price::");
		double price = sc.nextDouble();

		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

		CallableStatement pstmt = con.prepareCall(SQL);

		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setDouble(3, price);

		int cnt = pstmt.executeUpdate();
		System.out.println("Rows Affected::" + cnt);

		con.close();
	}

}

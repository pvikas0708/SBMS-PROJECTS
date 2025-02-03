package comselectops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectBooks {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjavadb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "root";

	public static final String SELECT_SQL = "SELECT * FROM BOOKS WHERE BOOK_ID=110";

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);

		con.createStatement();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(SELECT_SQL);

		if (rs.next()) {
			int bookid = rs.getInt("book_id");
			String name = rs.getString("book_name");
			double price = rs.getDouble("book_price");

			System.out.println(bookid);
			System.out.println(name);
			System.out.println(price);
		} else {
			System.out.println("Sorry, No record found...!");
		}
		// System.out.println(rs); //toString method will be called
		con.close();
	}

}

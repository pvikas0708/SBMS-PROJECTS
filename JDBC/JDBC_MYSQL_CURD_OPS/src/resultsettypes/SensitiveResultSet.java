package resultsettypes;

import java.sql.Connection;
import java.sql.DriverManager;

public class SensitiveResultSet {

	private static final String DB_URL="jdbc:mysql://localhost:3306/advjavadb";
	private static final String DB_UNAME="root";
	private static final String DB_PWD="root";

	final String INSERT_SQL="INSERT INTO BOOKS VALUES(130,'JAVAJDBC',1000)";
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
	}
}

package resultsettypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class demo {

	private static final String DB_URL="jdbc:mysql://localhost:3306/advjavadb";
	private static final String DB_UNAME="root";
	private static final String DB_PWD="root";

	final static String SELECT_SQL="select * from books";
	
	public static void main(String[] args) throws Exception {
		
		//step 1
				Class.forName("com.mysql.cj.jdbc.Driver"); //to load the class in JVM memory
				
				//step 2
				Connection con=DriverManager.getConnection(DB_URL,DB_UNAME,DB_PWD); // to connect DB and JAVA
				System.out.println(con);
				
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
				ResultSet rs = stmt.executeQuery(SELECT_SQL);
				
				System.out.println("query execution completed..! Data available in ResultSet...!");
				while (rs.next())
				{
					System.in.read();
					System.in.read();
					rs.refreshRow();
					System.out.println(rs.getInt(1)+"-----"+rs.getString(2)+"-----"+rs.getDouble(3));
				}
				con.close();
	}
}

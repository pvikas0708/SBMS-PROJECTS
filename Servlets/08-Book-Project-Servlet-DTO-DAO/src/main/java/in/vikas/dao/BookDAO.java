package in.vikas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.vikas.util.ConnectionFactory;

public class BookDAO {

	private static final String INSERT_SQL="insert into bookdetails values(?,?,?)";
	public boolean saveBook(int book_id,String book_name,double book_price) throws Exception
	{
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
		pstmt.setInt(1, book_id);
		pstmt.setString(2, book_name);
		pstmt.setDouble(3, book_price);
		
		int count = pstmt.executeUpdate();
		
		con.close();
		
		return count>0;
		
	}
	
	
}

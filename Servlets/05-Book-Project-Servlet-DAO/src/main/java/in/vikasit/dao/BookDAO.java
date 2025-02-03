package in.vikasit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.vikasit.dto.BookDTO;
import in.vikasit.util.ConnectionFactory;

public class BookDAO {

	// to insert records in DB Table in this table only DB operational methods will
	// be available.

	private static final String INSERT_SQL = "insert into Books values(?,?,?)";

	public boolean saveBooks(BookDTO dto) throws Exception {
		Connection con = ConnectionFactory.getConnection();

		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);

		pstmt.setInt(1, dto.getBook_id());
		pstmt.setString(2, dto.getBook_name());
		pstmt.setDouble(3, dto.getBook_price());

		int count = pstmt.executeUpdate();

		/*
		 * if (count > 0) { return true; } else { return false; } //too big code
		 */
		
		return count>0;
		
		//con.close(); no need to close the connection because connection pool will close the connection
	}
	

}

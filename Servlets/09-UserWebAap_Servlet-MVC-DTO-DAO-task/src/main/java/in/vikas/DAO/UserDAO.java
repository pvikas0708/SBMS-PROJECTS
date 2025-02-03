package in.vikas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.vikas.dto.UserDTO;
import in.vikas.util.ConnectionFactory;

public class UserDAO {

	private static final String INSERT_SQL = "insert into user_Details(user_name,user_email,user_phno)values(?,?,?)";

	private static final String SELECT_SQL = "select * from  user_Details";

	public boolean saveUser(UserDTO userDto) {
		boolean isSaved = false;

		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);

			pstmt.setString(1, userDto.getUserName());
			pstmt.setString(2, userDto.getUserEmail());
			pstmt.setLong(3, userDto.getUserph());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				isSaved = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSaved;
	}

	public List<UserDTO> getUser() {
		List<UserDTO> users = new ArrayList<>();

		try {
			Connection con = ConnectionFactory.getConnection();

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_SQL);

			while (rs.next()) {
				UserDTO user = new UserDTO();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserEmail(rs.getString(3));
				user.setUserph(rs.getLong(4));

				// adding users to list

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

}
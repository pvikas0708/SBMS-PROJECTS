package in.vikas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.vikas.dto.EmpDTO;
import in.vikas.util.ConnectionFactory;

public class EmpDAO {

	private static final String INSERT = "insert into EMP_DETAILS(EMP_NAME,EMP_EMAIL,EMP_GENDER,EMP_DEPT,EMP_EXP) values(?,?,?,?,?)";

	
	public boolean saveEmp(EmpDTO empdto) {
		int count = 0;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1, empdto.getEmpName());
			pstmt.setString(2, empdto.getEmpEmail());
			pstmt.setString(3, empdto.getEmpGender());
			pstmt.setString(4, empdto.getEmpDept());
			pstmt.setInt(5, empdto.getEmpExp());

			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count > 0;
	}

	public List<EmpDTO> getEmps(EmpDTO empdto) {

		StringBuilder sql = new StringBuilder("select * from EMP_DETAILS where 1=1");

		List<EmpDTO> emps=new ArrayList<EmpDTO>();

		try {

			if (empdto.getEmpDept() != null&& !empdto.getEmpDept().equals("")) {
				sql.append("and EMP_DEPT=?");
			}
			if (empdto.getEmpGender() != null&&!empdto.getEmpGender().equals("")) {
				sql.append("and EMP_GENDER=?");
			}
			if (empdto.getEmpExp() != null) {
				sql.append("and EMP_EXP=?");
			}

			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			int index = 1;

			if (empdto.getEmpDept() != null&& !empdto.getEmpDept().equals("")) {
				pstmt.setString(index, empdto.getEmpDept());
				index++;
			}
			if (empdto.getEmpGender() != null&&!empdto.getEmpGender().equals("")) {
				pstmt.setString(index, empdto.getEmpGender());
				index++;
			}
			if (empdto.getEmpExp() != null) {
				pstmt.setInt(index, empdto.getEmpExp());
			}

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
					EmpDTO dto=new EmpDTO();
					dto.setEmpId(rs.getInt("EMP_ID"));
					dto.setEmpName(rs.getString("EMP_NAME"));
					dto.setEmpEmail(rs.getString("EMP_EMAIL"));
					dto.setEmpDept(rs.getString("EMP_DEPT"));
					dto.setEmpGender(rs.getString("EMP_GENDER"));
					dto.setEmpExp(rs.getInt("EMP_EXP"));
					
					emps.add(dto);
					
					
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return emps;

	}

}

package in.vikas.servlet;

import java.io.IOException;
import java.util.List;

import in.vikas.dao.EmpDAO;
import in.vikas.dto.EmpDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class EmpRetriveServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// capture foem data

		String gender = req.getParameter("gender");
		String dept = req.getParameter("dept");
		String exp = req.getParameter("exp");

		// to represent data in object and pass that to DAO
		EmpDTO empdto = new EmpDTO();

		empdto.setEmpGender(gender);
		empdto.setEmpDept(dept);
		empdto.setEmpExp(Integer.parseInt(exp)); // converted exp with strong to int

		//call DAO method
		
		EmpDAO dao=new EmpDAO();
		List<EmpDTO> emps = dao.getEmps(empdto);
		
		req.setAttribute("emps", emps);
		req.getRequestDispatcher("/emps.jsp").forward(req, resp);
		
		
	}
}

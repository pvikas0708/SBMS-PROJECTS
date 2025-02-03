package in.vikas.servlet;

import java.io.IOException;

import in.vikas.dao.EmpDAO;
import in.vikas.dto.EmpDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class EmpInsertServlet extends HttpServlet {

	@Override // we are getting the data it should not come in URL it has to come in body
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// everything will come in string we need to con
		// capture foem data
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String dept = req.getParameter("dept");
		String exp = req.getParameter("exp");

		// to represent data in object and pass that to DAO
		EmpDTO empdto = new EmpDTO();
		empdto.setEmpName(name);
		empdto.setEmpEmail(email);
		empdto.setEmpGender(gender);
		empdto.setEmpDept(dept);
		empdto.setEmpExp(Integer.parseInt(exp)); // converted exp with strong to int

		// saving form data using DAO method
		EmpDAO empdao = new EmpDAO();
		boolean isSaved = empdao.saveEmp(empdto);

		String msg = null;
		if (isSaved) {
			msg = "Is saved Successfully..!";
		} else {
			msg = "Sorry,Faild to save";
		}

		// send msg to JSP page
		req.setAttribute("msg", msg);

		// redirect the request to same JSP page.
		req.getRequestDispatcher("/index.jsp").forward(req, resp);

	}

}

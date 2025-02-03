package in.vikas.servlet;

import java.io.IOException;
import java.util.List;

import in.vikas.DAO.UserDAO;
import in.vikas.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet{

	@Override
	//to retrive data
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		UserDAO userdao=new UserDAO();
		List<UserDTO> users = userdao.getUser();
		
		req.setAttribute("users", users); //to send msg from servlet to jsp
		req.getRequestDispatcher("/viewUsers.jsp").forward(req, resp);
	
	}
		
	@Override
	//to insert data
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//captureing Form Data
		String name = req.getParameter("name");
		String email=req.getParameter("email");
		String phno = req.getParameter("phno");
		
		//set form data to userdto object for transfer
		
		UserDTO user=new UserDTO();
		user.setUserName(name);
		user.setUserEmail(email);
		user.setUserph(Integer.parseInt(phno)); // conversion String to Integer
		
		//servlet calling dao method
		UserDAO dao=new UserDAO();
		boolean isSaved = dao.saveUser(user);
		
		String msg=null;
		
		if(isSaved)
		{
			msg="User Saved";
		}else
		{
			msg="User Not Saved";
		}
		req.setAttribute("msg", msg);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}
}

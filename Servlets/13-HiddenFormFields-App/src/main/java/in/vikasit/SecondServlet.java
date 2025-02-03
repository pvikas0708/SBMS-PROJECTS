package in.vikasit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uname = null;

		// Return existing session object
		HttpSession session = req.getSession(false);

		if (session != null) {
			uname = (String) session.getAttribute("uname");
		}

		PrintWriter out = resp.getWriter();

		if (uname != null && !uname.equals("")) {

			out.print("This is Second Servlet");
		} else {
			out.print("Sorry,This is Invalid Request..!");
		}

		
	}
}

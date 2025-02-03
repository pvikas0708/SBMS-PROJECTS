package in.vikas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{

			PrintWriter pw = resp.getWriter();
			pw.append("<h1>Hello Good Evening...!</h1>");
	}
	

}

package in.vikas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetServlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		PrintWriter pw = resp.getWriter();
		pw.append("<h1>Hello vikas Welcome...!</h1>");
	}
	
}

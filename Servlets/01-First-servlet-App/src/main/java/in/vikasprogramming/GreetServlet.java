package in.vikasprogramming;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/wel")
public class GreetServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		PrintWriter pw = resp.getWriter();
		
		pw.append("<h1>Hello Vikas, Good Evening...!</h1>");
	}
}

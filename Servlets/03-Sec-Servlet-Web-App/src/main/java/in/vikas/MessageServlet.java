package in.vikas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/msgServlet")
public class MessageServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{

		String name = req.getParameter("name");
		
		PrintWriter pw = resp.getWriter();
		
		pw.append("Good Evening..."+name);
	}
}

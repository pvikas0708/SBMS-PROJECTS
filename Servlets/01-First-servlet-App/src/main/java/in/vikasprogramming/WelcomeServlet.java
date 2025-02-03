package in.vikasprogramming;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/wc")
public class WelcomeServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp ) throws IOException
	{
		//System.out.println(); it will show data on console only so go for getwriter()
		
		PrintWriter pw = resp.getWriter(); //to write the message
		pw.append("<h1>Welcome to Servlets Programming by vikas</h1>");
		
	}


}



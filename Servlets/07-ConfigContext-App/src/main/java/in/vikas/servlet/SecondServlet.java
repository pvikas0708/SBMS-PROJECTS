package in.vikas.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet{
	
	@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		
		//getting config object 
		ServletConfig config = getServletConfig();
		String msg = config.getInitParameter("msg");
		
		//getting context object 
		ServletContext context = req.getServletContext();
		String website = context.getInitParameter("website");
		
		PrintWriter pw = resp.getWriter();
		pw.append(name+" ,---"+"website");
	}
}

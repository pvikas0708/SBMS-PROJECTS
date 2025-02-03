package in.vikasit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		PrintWriter out = res.getWriter();

		Cookie[] cookies = req.getCookies();

		if (cookies != null) {

			String value = cookies[0].getValue();
			System.out.println(value);

			if (value != null) {
				out.print("This is Second Servlet");
			} else {
				out.print("Invalid Request");
			}
		} else {
			out.print("Invalid Request");
		}
	}

}

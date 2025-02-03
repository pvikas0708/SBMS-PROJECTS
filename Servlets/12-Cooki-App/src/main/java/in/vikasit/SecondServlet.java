package in.vikasit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		Cookie[] cookies = req.getCookies();

		if (cookies != null) {
			String value = cookies[0].getValue();
			System.out.println(value);

			if (value != null) {

				out.append("This is Second Servlet");

			} else {
					out.print("Invalid Request..!");
			}
		}else {
			out.print("Invalid Request..!");
	}

	}
}

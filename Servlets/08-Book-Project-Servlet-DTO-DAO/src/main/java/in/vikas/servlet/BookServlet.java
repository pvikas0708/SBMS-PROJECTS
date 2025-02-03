package in.vikas.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.vikas.dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookservlet")
public class BookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// capture form data

			String id = req.getParameter("book_id");
			String name = req.getParameter("book_name");
			String price = req.getParameter("book_price");

			int bookid = Integer.parseInt(id);
			double bookprice = Double.parseDouble(price);
			// name is availble in String

			// call DAO methods by giving form data
			BookDAO dao = new BookDAO();
			boolean status = dao.saveBook(bookid, name, bookprice);

			// send response to client
			String response = null;
			if (status) {
				response = "Record Inserted";
			} else {
				response = "Record Insertion Failed0";
			}

			PrintWriter pw = resp.getWriter();
			pw.append(response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

package in.vikasit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.vikasit.dao.BookDAO;
import in.vikasit.dto.BookDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookservlet")
public class BookServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// capture form data
			int book_id=Integer.parseInt(req.getParameter("book_id"));
			String name = req.getParameter("book_name"); // Name is already in String format
			double book_price = Double.parseDouble(req.getParameter("book_price"));

			BookDTO dto=new BookDTO();
			dto.setBook_id(book_id);
			dto.setBook_name(name);
			dto.setBook_price(book_price);
			
			
			// call dao methods by giving form data

			BookDAO dao = new BookDAO(); // to call DAO class 
			
			boolean status = dao.saveBooks(dto);

			// send response to client

			String response = null;

			if (status) {
				response = "record Inserted";
			} else {
				response = "Insertion Failed";
			}

			PrintWriter pw = resp.getWriter();
			pw.append(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

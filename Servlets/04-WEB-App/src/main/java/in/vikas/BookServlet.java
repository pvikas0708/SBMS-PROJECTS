package in.vikas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookservlet")
public class BookServlet extends HttpServlet {

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{

		//capture data from form
		String bookId = req.getParameter("bookId");
		String bookName = req.getParameter("bookName");
		String bookPrice = req.getParameter("bookPrice");
		
		System.out.println(bookId);
		System.out.println(bookName);
		System.out.println(bookPrice);
		
		PrintWriter pw = resp.getWriter();
			
			pw.append("Great, Form Submitted..!");
	
			
			//capture data from database
					
			
			try
			{
				Connection con = DriverManager.getConnection("","","");

				String sql="insert into book vlaues(?,?,?)";
				
				PreparedStatement pstmt=con.prepareStatement(sql);
				
				//pstmt.setInt(1,bookId); but we received book id in String format because once data transferred from one server to another it get transferred in String format
							
				pstmt.setInt(1,Integer.parseInt(bookId));
				pstmt.setString(2,bookName);
				pstmt.setDouble(3,Double.parseDouble(bookPrice));
				
				int count=pstmt.executeUpdate();

				System.out.println("Rows Affected::"+count);
				pstmt.close();
				con.close();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
	}
	
}

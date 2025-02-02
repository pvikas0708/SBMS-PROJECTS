package in.vikas.binding;

public class Book {

	private Integer bookId;
	private String BookName;
	private double bookPrice;

	
	public Book() {
		// TODO Auto-generated constructor stub
	}


	public Book(Integer bookId, String bookName, double bookPrice) {
		super();
		this.bookId = bookId;
		BookName = bookName;
		this.bookPrice = bookPrice;
	}


	public Integer getBookId() {
		return bookId;
	}


	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return BookName;
	}


	public void setBookName(String bookName) {
		BookName = bookName;
	}


	public double getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", BookName=" + BookName + ", bookPrice=" + bookPrice + "]";
	}
	
	
}

package in.vikas.entity;

import jakarta.persistence.Embeddable;

@Embeddable //java class which contains PK column Names.
public class BookPK {

	//this class represents all the PK columns.
	private Integer bookId;
	private String  bookName;
	
	public BookPK() {
		// TODO Auto-generated constructor stub
	}
	
		
	public BookPK(Integer bookId, String bookName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
	}




	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "BookPK [bookId=" + bookId + ", bookName=" + bookName + "]";
	}
	
	
}

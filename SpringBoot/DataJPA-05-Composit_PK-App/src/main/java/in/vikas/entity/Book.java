package in.vikas.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKS_INFO_TBL")
public class Book {

	private double price;
	private String autherName;
	
	
	@EmbeddedId //it represents the class which has the PK
	private BookPK bookpk;

	
	public Book() {
		// TODO Auto-generated constructor stub
	}


	public Book(double price, String autherName, BookPK bookpk) {
		super();
		this.price = price;
		this.autherName = autherName;
		this.bookpk = bookpk;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getAutherName() {
		return autherName;
	}


	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}


	public BookPK getBookpk() {
		return bookpk;
	}


	public void setBookpk(BookPK bookpk) {
		this.bookpk = bookpk;
	}


	@Override
	public String toString() {
		return "Book [price=" + price + ", autherName=" + autherName + ", bookpk=" + bookpk + "]";
	}
	
	
	
}

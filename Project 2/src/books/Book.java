
/**
 * This is the Book class were we find the attributes, methods(equals, to string,...) of each book
 *  object that needs to be created. 
 */
package books;

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title;
	private String authors;
	private double price;
	private String isbn;
	private String genre;
	private int year;
	/**
	 * Default constructor
	 */
	public Book() {
		title="";
		authors="";
		price=0;
		isbn="";
		genre="";
		year=0;		
	}
	/**
	 * parameterized constructor
	 * @param t is the Title
	 * @param a is the authors
	 * @param p is the price
	 * @param i is the ISBN
	 * @param g is the genre
	 * @param y is the year
	 */
	public Book(String t, String a, double p, String i, String g, int y) {
		this.title=t;
		this.authors=a;
		this.price=p;
		this.isbn=i;
		this.genre=g;
		this.year=y;
	}
	/**
	 * Copy Constructor
	 * @param book is a book object
	 */
	public Book(Book book) {
		this.title=book.title;
		this.authors=book.authors;
		this.price=book.price;
		this.isbn=book.isbn;
		this.genre=book.genre;
		this.year=book.year;
	}
	/**
	 * Get Title
	 * @return which returns title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Set Title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Get authors
	 * @return which returns authors
	 */
	public String getAuthors() {
		return authors;
	}
	/**
	 * Set authors
	 * @param authors
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	/**
	 * Get Price
	 * @return which returns price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Set Price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Get Isbn
	 * @return which returns Isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * Set Isbn
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * Get Genre
	 * @return which returns genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * Set genre
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * Get Title
	 * @return which returns title
	 */
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * To String method that was override
	 */
	@Override
	public String toString() {
		return "Book Title: " + getTitle() + ", Author(s): " + getAuthors() + ", Price: " + getPrice()
				+ ", ISBN: " + getIsbn() + ", Genre: " + getGenre() + ", Year: " + getYear();
	}
	/**
	 * Equals method was override
	 * takes an Object x
	 */
	@Override
	public boolean equals(Object x) {
		if(x==null||this.getClass()!=x.getClass()) {
			return false;
		}
		else {
			Book b = (Book)x;
			return (this.title == b.title && this.authors == b.authors &&
					this.price == b.price &&this.isbn == b.isbn && 
					this.genre == b.genre && this.year == b.year );
		}
	}
}
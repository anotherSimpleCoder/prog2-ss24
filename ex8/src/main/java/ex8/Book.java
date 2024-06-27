package ex8;

import java.time.LocalDate;
import java.util.Comparator;

public class Book implements Comparable<Book> {
	private String title;
	private String author;
	private int year;
	private int pages;
	private String genre;
	private double rating;
	private boolean borrowed;
	private LocalDate returnDate;
	
	public static Comparator<Book> bookReturnDateComparator = (book1, book2) -> book1.returnDate.compareTo(book2.returnDate);
	
	public Book(String title, String author, int year, int pages, String genre, double rating, boolean borrowed, LocalDate returnDate) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.pages = pages;
		this.genre = genre;
		this.rating = rating;
		this.borrowed = borrowed;
		this.returnDate = returnDate;
	}
	
	public Book(String title, String author, int year, int pages, String genre, double rating) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.pages = pages;
		this.genre = genre;
		this.rating = rating;
		this.borrowed = false;
		this.returnDate = null;
	}
	
	public String getTitle() {
		return title;
	}
	
	public LocalDate getReturnDate() {
		return returnDate;
	}

	@Override
	public int compareTo(Book o) {
		return this.title.compareTo(o.getTitle());
	}
	
	public int getYear() {
		return year;
	}
	
	public int getPages() {
		return pages;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public double getRating() {
		return rating;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", pages=" + pages + ", genre="
				+ genre + ", rating=" + rating + ", borrowed=" + borrowed + ", returnDate=" + returnDate + "]";
	}
	
}

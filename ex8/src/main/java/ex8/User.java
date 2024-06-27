package ex8;

import java.time.LocalDateTime;
import java.util.TreeSet;

public class User {
	private String name;
	private String readerId;
	private TreeSet<Book> borrowedBooks;
	
	public User(String name, String readerId) {
		this.borrowedBooks = new TreeSet<>(Book.bookReturnDateComparator);
	}
	
	public void borrow(Book bookToBorrow) {
		bookToBorrow.setBorrowed(true);
		bookToBorrow.setReturnDate(LocalDateTime.now().toLocalDate());
		borrowedBooks.add(bookToBorrow);
	}
	
	public void returnBook(Book bookToReturn) {
		borrowedBooks.remove(bookToReturn);
	}
	
	public TreeSet<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
}

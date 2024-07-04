package ex8;

import java.time.LocalDateTime;
import java.util.TreeSet;

public class User {
	private String name;
	private String readerId;
	private TreeSet<Book> borrowedBooks;
	
	public User(String name, String readerId) {
		this.setName(name);
		this.setReaderId(readerId);
		
		this.borrowedBooks = new TreeSet<>(Book.bookReturnDateComparator);
	}
	
	public void borrow(Book bookToBorrow) {
		bookToBorrow.setBorrowed(true);
		bookToBorrow.setReturnDate(LocalDateTime.now().toLocalDate());
		borrowedBooks.add(bookToBorrow);
	}
	
	public void returnBook(Book bookToReturn) {
		bookToReturn.setBorrowed(false);
		bookToReturn.setReturnDate(null);
		borrowedBooks.remove(bookToReturn);
	}
	
	public TreeSet<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	
	public void setName(String name) {
		if(!name.strip().isEmpty() && name != null)
			this.name = name;
	}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		if(!readerId.strip().isEmpty() && readerId != null)
			this.readerId = readerId;
	}

	public String getName() {
		return name;
	}
}

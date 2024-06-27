package ex8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LibraryManagementSystem {
	private TreeSet<Book> books;
	private HashMap<String, User> users;
	private TreeSet<Book> borrowedBooks;
	
	public LibraryManagementSystem() {
		this.books = new TreeSet<>();
		this.users = new HashMap<>();
		this.borrowedBooks = new TreeSet<>(Book.bookReturnDateComparator);
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
	public void borrow(String userId, Book book) throws Exception {
		if(this.borrowedBooks.contains(book)) {
			throw new Exception("Dieses Buch wurde schon ausgeliehen!");
		}
		
		User user = this.users.get(userId);
		user.borrow(book);
		this.borrowedBooks.add(book);
	}
	
	public void returnBook(String userId, Book book) throws Exception {
		if(!this.borrowedBooks.contains(book)) {
			throw new Exception("Dieses Buch wurde nicht ausgeliehen!");
		}
		
		User user = this.users.get(userId);
		user.returnBook(book);
		this.borrowedBooks.remove(book);

	}
	
	public TreeSet<Book> getAllBooks() {
		return this.books;
	}
	
	public Set<Book> booksBorrowedByUser(String userId) {
		User user = this.users.get(userId);
		return user.getBorrowedBooks();
	}
	
	public Set<Book> allBorrowedBooks() {
		return this.borrowedBooks;
	}
	
	public Set<Book> getBooksByYear(int year) {
		return this.books.stream()
			.filter(book -> book.getYear() == year)
			.collect(Collectors.toSet());
	}

	public List<Book> sortByAmountOfPages() {
		return this.filterAndSortBooks((book1, book2) -> Integer.compare(book1.getPages(), book2.getPages()), null);
	}
	
	public int totalPages() {
		return this.books.stream()
				.map(book -> book.getPages())
				.reduce(0, (acc, element) -> element);
	}
	
	public List<Book> filterBooksByGenre(String genre) {
		return this.filterAndSortBooks(null, book -> book.getGenre().equals(genre));
	}

	public TreeMap<String, Double> calculateAverageRatingPerGenre() {
		TreeMap<String, Double> averageRatings = new TreeMap();
		Set<String> genres = this.books.stream().map(book -> book.getGenre()).collect(Collectors.toSet());
		
		for(String genre: genres) {
			List<Book> booksOfGenre = this.filterBooksByGenre(genre);
			double ratingSum = booksOfGenre.stream()
					.map(book -> book.getRating())
					.reduce(0.0, (acc, rating) -> acc + rating);
			
			averageRatings.put(genre, ratingSum / booksOfGenre.size());
		}
		
		return averageRatings;
	}
	
	public List<Book> topThreeBooks() {
		List<Book> topBooks = this.sortByRating();
		
		return topBooks.stream().limit(3).collect(Collectors.toList());
	}
	
	public Set<String> authorsWithTheMostBooks() {
		Set<String> authors = this.books.stream()
			.map(book -> book.getAuthor())
			.collect(Collectors.toSet());
		
		
		return authors;
	}
	
	public List<Book> sortByRating() {
		return this.filterAndSortBooks((book1, book2) -> Double.compare(book1.getRating(), book2.getRating()), null);
	}
	
	public List<Book> filterAndSortBooks(Comparator<Book> sortingCriterion, Predicate<Book> filterCriterion) {
		if(sortingCriterion == null) {
			sortingCriterion = (book1, book2) -> 1;
		}
		
		if(filterCriterion == null) {
			filterCriterion = book -> true;
		}
		
		return this.books.stream()
				.sorted(sortingCriterion)
				.filter(filterCriterion)
				.collect(Collectors.toList());
	}
}

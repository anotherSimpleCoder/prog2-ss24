package ex8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Predicate;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class LibraryCLI {
    private LibraryManagementSystem libraryManagementSystem;
    private Scanner scanner;

    public LibraryCLI(LibraryManagementSystem libraryManagementSystem) {
        this.libraryManagementSystem = libraryManagementSystem;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        loadBooksFromCSV("books.csv");

        boolean running = true;

        while (running) {
            System.out.println("\n--- Bücherverwaltungssystem ---");
            System.out.println("1. Buch hinzufügen");
            System.out.println("2. Alle Bücher anzeigen");
            System.out.println("3. Bücher nach Jahr filtern");
            System.out.println("4. Bücher nach Seitenanzahl sortieren");
            System.out.println("5. Gesamtanzahl der Seiten berechnen");
            System.out.println("6. Buch ausleihen");
            System.out.println("7. Buch zurückgeben");
            System.out.println("8. Ausgeliehene Bücher eines Nutzers anzeigen");
            System.out.println("9. Alle ausgeliehenen Bücher anzeigen, sortiert nach Rückgabedatum");
            System.out.println("10. Bücher nach Genre filtern");
            System.out.println("11. Durchschnittliche Bewertung pro Genre berechnen");
            System.out.println("12. Top-bewertete Bücher anzeigen");
            System.out.println("13. Autoren mit den meisten Büchern anzeigen");
            System.out.println("14. Bücher nach Bewertung sortieren");
            System.out.println("15. Gefilterte und sortierte Liste der Bücher anzeigen");
            System.out.println("16. Programm beenden");
            System.out.print("Bitte wählen Sie eine Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    filterBooksByYear();
                    break;
                case 4:
                    sortBooksByPages();
                    break;
                case 5:
                    calculateTotalPages();
                    break;
                case 6:
                    borrowBook();
                    break;
                case 7:
                    returnBook();
                    break;
                case 8:
                    displayBorrowedBooksByUser();
                    break;
                case 9:
                    displayAllBorrowedBooks();
                    break;
                case 10:
                    filterBooksByGenre();
                    break;
                case 11:
                    calculateAverageRatingPerGenre();
                    break;
                case 12:
                    displayTopRatedBooks();
                    break;
                case 13:
                    displayAuthorsWithMostBooks();
                    break;
                case 14:
                    sortBooksByRating();
                    break;
                case 15:
                    filterAndSortBooks();
                    break;
                case 16:
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte versuchen Sie es erneut.");
            }
        }
    }

    private void loadBooksFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
   
        	CSVParser csvParser = CSVParser.parse(br, CSVFormat.EXCEL.builder().setHeader().build());
        	String title, author, genre;
        	int pages, year;
        	double rating;
        	
        	for(CSVRecord bookCSVRecord: csvParser) {
        		title = bookCSVRecord.get("title");
        		author = bookCSVRecord.get("author");
        		genre = bookCSVRecord.get("genre");
        		
        		year = Integer.parseInt(bookCSVRecord.get("year"));
        		pages = Integer.parseInt(bookCSVRecord.get("pages"));
        		
        		rating = Double.parseDouble(bookCSVRecord.get("rating"));
        		
        		Book parsedBook = new Book(title, author, year, pages, genre, rating);
        		this.libraryManagementSystem.addBook(parsedBook);
        	}
        	
        	
            System.out.println("Bücher aus CSV-Datei geladen.");
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addBook() {
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Veröffentlichungsjahr: ");
        int year = scanner.nextInt();
        System.out.print("Anzahl der Seiten: ");
        int pages = scanner.nextInt();
        System.out.print("Genre: ");
        String genre = scanner.next();
        System.out.print("Bewertung: ");
        double rating = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Book bookToAdd = new Book(title, author, year, pages, genre, rating);
        System.out.println("Buch hinzugefügt!");
    }

    private void displayAllBooks() {
    	Set<Book> allBooks = this.libraryManagementSystem.getAllBooks();
    	System.out.println(allBooks);
    }

    private void filterBooksByYear() {
    	System.out.print("Geben Sie das zu filternde Jahr ein: ");
    	int year = scanner.nextInt();
    	Set<Book> filteredBooks = this.libraryManagementSystem.getBooksByYear(year);
    	
    	System.out.println(filteredBooks);
    }

    private void sortBooksByPages() {
    	List<Book> booksSortedByPages = this.libraryManagementSystem.sortByAmountOfPages();
    	System.out.println(booksSortedByPages);
    }

    private void calculateTotalPages() {
    	int totalPages = this.libraryManagementSystem.totalPages();
    	System.out.println(totalPages);
    }

    private void borrowBook() {
    	System.out.print("Geben Sie die Nutzer-ID des ausleihenden Nutzers an: ");
    	String userId = scanner.next();
    	

    	Predicate<Book> searchCriterion = this.constructBookSearchPredicate();
    	List<Book> foundBooks = this.libraryManagementSystem.filterAndSortBooks(null, searchCriterion);
    	
    	try {
    		libraryManagementSystem.borrow(userId, foundBooks.getFirst());
    	} catch(Exception e) {
    		System.err.println("Folgender Fehler ist beim Ausleihen aufgetreten: " + e.getLocalizedMessage());
    	}
    }

    private void returnBook() {
    	System.out.print("Geben Sie die Nutzer-ID des zurückgebenden Nutzers ein: ");
    	String userId = scanner.next();
    	
    	Set<Book> booksBorrowedByUser = this.libraryManagementSystem.booksBorrowedByUser(userId);
    	Predicate<Book> searchCriterion = this.constructBookSearchPredicate();
    	Book foundBook = booksBorrowedByUser.stream()
    			.filter(searchCriterion)
    			.findFirst()
    			.get();
    	
    	try {
    		this.libraryManagementSystem.returnBook(userId, foundBook);
    	} catch(Exception e) {
    		System.err.println("Folgender Fehler ist bei der Rückgabe aufgetreten: " + e.getLocalizedMessage());
    	}
    }

    private void displayBorrowedBooksByUser() {
    	System.out.print("Geben Sie die Nutzer-ID des zurückgebenden Nutzers ein: ");
    	String userId = scanner.next();
    	Set<Book> booksBorrowedByUser = this.libraryManagementSystem.booksBorrowedByUser(userId);
    	
    	System.out.println(booksBorrowedByUser);
    }

    private void displayAllBorrowedBooks() {
    	System.out.println("Dies sind alle aktuell ausgeliehenen Bücher: ");
    	System.out.println(this.libraryManagementSystem.allBorrowedBooks());
    }

    private void filterBooksByGenre() {
    	System.out.print("Geben Sie das Genre ein, nach dem gefiltert werden soll: ");
    	String genre = scanner.next();
    	List<Book> foundBooks = this.libraryManagementSystem.filterBooksByGenre(genre);
    	
    	System.out.println(foundBooks);
    }

    private void calculateAverageRatingPerGenre() {
    	System.out.println("Dies sind die durchschnittlichen Bewertungen, pro Genre:");
    	TreeMap<String, Double> averageRatings = this.libraryManagementSystem.calculateAverageRatingPerGenre();
    	
    	for(String genre: averageRatings.keySet()) {
    		System.out.printf("%s: %.2f", genre, averageRatings.get(genre));
    	}
    }

    private void displayTopRatedBooks() {
    	System.out.println("Dies sind die aktuell 3 best bewertetsten Bücher: ");
    	List<Book> topRatedBooks = this.libraryManagementSystem.topThreeBooks();
    	
    	System.out.println(topRatedBooks);
    }

    private void displayAuthorsWithMostBooks() {
    	System.out.println("Dies sind die Autorn, mit den meisten Büchern");
    	TreeMap<Integer, String> authorsWithMostBooks = this.libraryManagementSystem.authorsWithTheMostBooks();
    	
    	System.out.println(authorsWithMostBooks);
    }

    private void sortBooksByRating() {
    	System.out.println("Bücher sortiert nach ihrer Bewertung:");
    	List<Book> booksSortedByRating = this.libraryManagementSystem.sortByRating();
    	
    	System.out.println(booksSortedByRating);
    }

    private void filterAndSortBooks() {
        System.out.println("Filtern nach benutzerdefinierten Kriterien:");
        System.out.println("1. Nach Jahr");
        System.out.println("2. Nach Seitenanzahl");
        System.out.println("3. Nach Bewertung");
        System.out.print("Wählen Sie ein Filterkriterium: ");
        int filterChoice = scanner.nextInt();
        System.out.print("Wählen Sie 1 für > oder 2 für <: ");
        int comparison = scanner.nextInt();
        System.out.print("Geben Sie den Wert ein: ");
        double filterValue = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Predicate<Book> filter;
        int expectedCompareValue = filterChoice == 2 ? -1 : filterChoice;
        
        
        switch (filterChoice) {
            case 1: {
            	filter = book -> Double.compare(book.getYear(), filterValue) == expectedCompareValue;
                break;
            }
                
            case 2: {
            	filter = book -> Double.compare(book.getPages(), filterValue) == expectedCompareValue;
                break;
            }
                
            case 3: {
            	filter = book -> Double.compare(book.getRating(), filterValue) == expectedCompareValue;
                break;
            }
                
            default:
                System.out.println("Ungültige Auswahl.");
                return;
        }

        System.out.println("Sortieren nach benutzerdefinierten Kriterien:");
        System.out.println("1. Nach Titel");
        System.out.println("2. Nach Jahr");
        System.out.println("3. Nach Seitenanzahl");
        System.out.println("4. Nach Bewertung");
        System.out.print("Wählen Sie ein Sortierkriterium: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Comparator<Book> sorter;
        switch (sortChoice) {
            case 1: {
            	sorter = (book1, book2) -> book1.getTitle().compareTo(book2.getTitle());
                break;
            }
                
            case 2:
                sorter = (book1, book2) -> Integer.compare(book1.getYear(), book2.getYear());
                break;
            case 3:
                sorter = (book1, book2) -> Integer.compare(book1.getPages(), book2.getPages());
                break;
            case 4:
                sorter = (book1, book2) -> Double.compare(book1.getRating(), book2.getRating());
                break;
            default:
                System.out.println("Ungültige Auswahl.");
                return;
        }

        List<Book> result = libraryManagementSystem.filterAndSortBooks(sorter, filter);
        result.forEach(System.out::println);
    }

    private Predicate<Book> constructBookSearchPredicate() {
    	System.out.println("Geben Sie den Titel des Buches ein: ");
    	String title = scanner.next();
    	
    	System.out.println("Geben Sie den Autor des Buches an: ");
    	String author = scanner.next();
    	
    	System.out.println("Geben Sie das Veröffentlichsjahr des Buches ein: ");
    	int year = scanner.nextInt();
    
    	Predicate<Book> searchCriterion = book -> {
    		return book.getTitle().equals(title)
    				&& book.getAuthor().equals(author)
    				&& book.getYear() == year;
    	};
    	
    	return searchCriterion;
    }
    
    public static void main(String[] args) {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        LibraryCLI libraryCLI = new LibraryCLI(libraryManagementSystem);
        libraryCLI.run();
    }
}

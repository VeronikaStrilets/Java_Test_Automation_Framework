package lesson13hw12task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Book> booksArrayList;
    private List<Book> booksLinkedList;

    public Inventory() {
        booksArrayList = new ArrayList<>();
        booksLinkedList = new LinkedList<>();
    }

    // Add a new book
    public void addBook(Book book) {
        booksArrayList.add(book);
        booksLinkedList.add(book);
    }

    // Remove a book
    public void removeBook(Book book) {
        booksArrayList.remove(book);
        booksLinkedList.remove(book);
        System.out.println(book + "' was successfully removed.");
    }

    // Remove a book by title
    public void removeBookByTitle(String title) {
        booksArrayList.removeIf(book -> book.getTitle().equals(title));
        booksLinkedList.removeIf(book -> book.getTitle().equals(title));
        System.out.println("Book with title '" + title + "' was successfully removed.");
    }

    // Remove a book by author
    public void removeBookByAuthor(String author) {
        booksArrayList.removeIf(book -> book.getAuthor().equals(author));
        booksLinkedList.removeIf(book -> book.getAuthor().equals(author));
        System.out.println("Books by author '" + author + "' were successfully removed.");
    }

    // List all books
    public void displayAllBooks() {
        System.out.println("Books in the inventory:");
        for (Book book : booksArrayList) {
            System.out.println(book.getTitle());
        }
    }

    // Find a book by title
    public Book findBookByTitle(String title) {
        for (Book book : booksArrayList) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book with title '" + title + "' was successfully found.");
                return book;
            }
        }
        System.out.println("No book found with title '" + title + "'.");
        return null;
    }

    // Find a book by country
    public Book findBookByCountry(String country) {
        for (Book book : booksArrayList) {
            if (book.getCountry().equals(country)) {
                System.out.println("Books from country '" + country + "' was successfully found.");
                return book;
            }
        }
        System.out.println("No book found from country '" + country + "'.");
        return null;
    }

    // Update book info
    public void updateBookInfo(String title, double newPrice) {
        for (Book book : booksArrayList) {
            if (book.getTitle().equals(title)) {
                book.setPrice(newPrice);
                System.out.println("Book info was successfully updated.");
                return;
            }
        }
        System.out.println("No book found with title '" + title + "'.");
    }
}

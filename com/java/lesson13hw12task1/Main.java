package lesson13hw12task1;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Book tigerTrappers = new Book("Tiger Trappers", "Iwan Bahrjanyj", "Ukraine", 200.00);
        Book martinEden = new Book("Martin Eden", "Jack London", "England", 250.00);
        Book prideAndPrejudice = new Book("Pride & Prejudice", "Jane Austen", "England", 190.00);

        inventory.addBook(tigerTrappers);
        inventory.addBook(martinEden);
        inventory.addBook(prideAndPrejudice);

        inventory.displayAllBooks();
        inventory.findBookByTitle("Martin Eden");
        inventory.findBookByCountry("England");
        inventory.updateBookInfo("Tiger Trappers", 210);

        inventory.removeBook(tigerTrappers);
        inventory.removeBookByAuthor("Jack London");
        inventory.removeBookByTitle("Pride & Prejudice");
    }
}

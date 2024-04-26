package lesson13hw12task1;

public class Book {
    private String title;
    private String author;
    private String country;
    private double price;

    public Book(String title, String author, String country, double price) {
        this.title = title;
        this.author = author;
        this.country = country;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCountry() {
        return country;
    }

    public double setPrice(double newPrice) {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", country=" + country +
                ", price=" + price +
                '}';
    }
}

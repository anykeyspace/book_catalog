package anykeyspace.bookcatalog.view;

public class BookView {

    private int bookNumber;
    private String name;
    private int year;
    private String genre;
    private AuthorView author;
    private String description;

    // for jackson
    public BookView() {
    }

    public BookView(String name, int year, String genre, AuthorView author, String description) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.author = author;
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookView{" +
                "bookNumber=" + bookNumber +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", author=" + author +
                ", description='" + description + '\'' +
                '}';
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public AuthorView getAuthor() {
        return author;
    }

    public void setAuthor(AuthorView author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

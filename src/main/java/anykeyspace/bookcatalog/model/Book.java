package anykeyspace.bookcatalog.model;

import javax.persistence.*;

@Entity(name = "Book")
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @Column(unique = true)
    private Integer bookNumber;

    @Basic(optional = false)
    private String name;

    private int year;

    private String genre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id")
    private Author author;

    private String description;

    // для hibernate
    public Book() {
    }

    public Book(Integer bookNumber, String name) {
        this.bookNumber = bookNumber;
        this.name = name;
    }

    public Book(Integer bookNumber, String name, Author author) {
        this.bookNumber = bookNumber;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNumber=" + bookNumber +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", author=" + author +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

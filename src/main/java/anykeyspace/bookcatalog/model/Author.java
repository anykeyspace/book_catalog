package anykeyspace.bookcatalog.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @Column(unique = true)
    private Integer authorNumber;

    @Basic(optional = false)
    private String firstName;

    @Basic(optional = false)
    private String lastName;

    private String country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Book> books;

    // для hibernate
    public Author() {
    }

    public Author(Integer authorNumber, String firstName, String lastName) {
        this.authorNumber = authorNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorNumber=" + authorNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", books=" + books +
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

    public Integer getAuthorNumber() {
        return authorNumber;
    }

    public void setAuthorNumber(Integer authorNumber) {
        this.authorNumber = authorNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

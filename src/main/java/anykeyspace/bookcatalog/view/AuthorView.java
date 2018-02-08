package anykeyspace.bookcatalog.view;

import java.util.List;

public class AuthorView {

    private int authorNumber;
    private String firstName;
    private String lastName;
    private String country;
    private List<BookListView> books;

    //for jackson
    public AuthorView() {
    }

    public AuthorView(String firstName, String lastName, String country, List<BookListView> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorView{" +
                "authorNumber=" + authorNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", books=" + books +
                '}';
    }

    public int getAuthorNumber() {
        return authorNumber;
    }

    public void setAuthorNumber(int author_number) {
        this.authorNumber = author_number;
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

    public List<BookListView> getBooks() {
        return books;
    }

    public void setBooks(List<BookListView> books) {
        this.books = books;
    }
}

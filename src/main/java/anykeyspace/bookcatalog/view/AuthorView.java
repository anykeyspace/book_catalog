package anykeyspace.bookcatalog.view;

import java.util.List;

public class AuthorView {

    private String firstName;
    private String lastName;
    private String country;
    private List<BookView> books;

    //for jackson
    public AuthorView() {
    }

    public AuthorView(String firstName, String lastName, String country, List<BookView> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorView{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", books=" + books +
                '}';
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

    public List<BookView> getBooks() {
        return books;
    }

    public void setBooks(List<BookView> books) {
        this.books = books;
    }
}

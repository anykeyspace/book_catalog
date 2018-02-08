package anykeyspace.bookcatalog.service;

import anykeyspace.bookcatalog.model.Author;
import anykeyspace.bookcatalog.model.Book;
import anykeyspace.bookcatalog.view.AuthorView;
import anykeyspace.bookcatalog.view.BookListView;
import anykeyspace.bookcatalog.view.BookView;

import java.util.stream.Collectors;

/**
 * Класс, содержащий методы для преобразований model-view и view-model.
 */
public class ViewConverter {

    public static Book bookFromView(BookView view) {
        if (view == null) {
            throw new NullPointerException("bookFromView needs a BookView object");
        }

        Book book = new Book();

        book.setBookNumber(view.getBookNumber());
        book.setName(view.getName());
//        book.setAuthor(view.getAuthor());
        book.setGenre(view.getGenre());
        book.setYear(view.getYear());
        book.setDescription(view.getDescription());

        return book;
    }

    public static BookView bookToView(Book book) {
        if (book == null) {
            throw new NullPointerException("bookToView needs a Book object");
        }

        BookView view = new BookView();

        view.setBookNumber(book.getBookNumber());
        view.setName(book.getName());
        view.setGenre(book.getGenre());
        view.setYear(book.getYear());
        view.setDescription(book.getDescription());

        Author author = book.getAuthor();
        if (author != null) {
            view.setAuthor(authorToView(book.getAuthor()));
        }

        return view;
    }

    private static BookListView bookToListView(Book book) {
        if (book == null) {
            throw new NullPointerException("bookToListView needs a Book object");
        }

        BookListView view = new BookListView();

        view.setName(book.getName());
        view.setYear(book.getYear());

        return view;
    }

    public static Author authorFromView(AuthorView view) {
        if (view == null) {
            throw new NullPointerException("authorFromView needs a AuthorView object");
        }

        Author author = new Author();

        author.setAuthorNumber(view.getAuthorNumber());
        author.setFirstName(view.getFirstName());
        author.setLastName(view.getLastName());
        author.setCountry(view.getCountry());
//        author.setBooks(view.getBooks());

        return author;
    }

    public static AuthorView authorToView(Author author) {
        if (author == null) {
            throw new NullPointerException("authorToView needs a Author object");
        }

        AuthorView view = new AuthorView();

        view.setAuthorNumber(author.getAuthorNumber());
        view.setFirstName(author.getFirstName());
        view.setLastName(author.getLastName());
        view.setCountry(author.getCountry());
        view.setBooks(author.getBooks().stream().map(ViewConverter::bookToListView).collect(Collectors.toList()));

        return view;
    }
}

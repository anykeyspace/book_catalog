package anykeyspace.bookcatalog.controller;

import anykeyspace.bookcatalog.service.AuthorService;
import anykeyspace.bookcatalog.service.BookService;
import anykeyspace.bookcatalog.view.AuthorView;
import anykeyspace.bookcatalog.view.BookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class RootController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public RootController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    /**
     * Just for test
     *
     * @return
     */
    @RequestMapping("/test")
    public String index() {
        return "Spring Boot test";
    }

    /**
     * Add book
     *
     * @param view
     */
    @PostMapping("/book")
    public void addBook(@RequestBody BookView view) {
        bookService.addBook(view);
    }

    /**
     * Get all books
     *
     * @return JSON books value
     */
    @GetMapping("/book")
    public List<BookView> getAllBooks() {
        return bookService.loadAllBooks();
    }

    /**
     * Get all authors
     *
     * @return JSON authors value
     */
    @GetMapping("/author")
    public List<AuthorView> getAllAuthors() {
        return authorService.loadAllAuthors();
    }

}

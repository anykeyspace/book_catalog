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
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
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
     * Add/update book
     *
     * @param view
     */
    @PostMapping("/book")
    public void addBook(@RequestBody BookView view,
                        @RequestParam(value = "type", required = false, defaultValue = "new") String type) {

        switch (type) {
            case "new":
                bookService.addBook(view);
                break;

            case "update":
                bookService.updateBook(view);
                break;

            default:
                bookService.addBook(view);
                break;
        }
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
     * Add author
     *
     * @param view
     */
    @PostMapping("/author")
    public void addAuthor(@RequestBody AuthorView view) {
        authorService.addAuthor(view);
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

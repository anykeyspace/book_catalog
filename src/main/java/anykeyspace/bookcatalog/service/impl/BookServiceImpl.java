package anykeyspace.bookcatalog.service.impl;

import anykeyspace.bookcatalog.dao.BookDAO;
import anykeyspace.bookcatalog.model.Book;
import anykeyspace.bookcatalog.service.BookService;
import anykeyspace.bookcatalog.view.BookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookDAO dao;

    @Autowired
    public BookServiceImpl(BookDAO dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addBook(BookView view) {
        Book book = new Book(view.getName());
        dao.save(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<BookView> loadAllBooks() {
        List<Book> bookList = dao.loadAll();

        Function<Book, BookView> mapBook = book -> {
            BookView view = new BookView();
            view.setName(book.getName());
//            view.setAuthor();
            view.setGenre(book.getGenre());
            view.setYear(book.getYear());
            view.setDescription(book.getDescription());

            return view;
        };

        return bookList.stream()
                .map(mapBook)
                .collect(Collectors.toList());
    }
}

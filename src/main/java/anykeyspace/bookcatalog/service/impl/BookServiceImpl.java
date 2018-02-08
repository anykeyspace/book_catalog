package anykeyspace.bookcatalog.service.impl;

import anykeyspace.bookcatalog.dao.BookDAO;
import anykeyspace.bookcatalog.model.Book;
import anykeyspace.bookcatalog.service.BookService;
import anykeyspace.bookcatalog.service.ViewConverter;
import anykeyspace.bookcatalog.view.BookView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookDAO dao;
    private final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

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
        Book book = ViewConverter.bookFromView(view);
        dao.save(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateBook(BookView view) {
        Book book = ViewConverter.bookFromView(view);
        dao.update(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<BookView> loadAllBooks() {
        List<Book> bookList = dao.loadAll();

        return bookList.stream()
                .map(ViewConverter::bookToView)
                .collect(Collectors.toList());
    }
}

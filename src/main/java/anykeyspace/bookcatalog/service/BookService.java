package anykeyspace.bookcatalog.service;

import anykeyspace.bookcatalog.view.BookView;

import java.util.List;

/**
 * Books service
 */
public interface BookService {

    /**
     * Book add method
     *
     * @param view
     */
    void addBook(BookView view);

    /**
     * Update Book method
     *
     * @param view
     */
    void updateBook(BookView view);

    /**
     * All books load method
     *
     * @return
     */
    List<BookView> loadAllBooks();
}

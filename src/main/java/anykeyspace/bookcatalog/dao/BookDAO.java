package anykeyspace.bookcatalog.dao;


import anykeyspace.bookcatalog.exception.NoSuchIdException;
import anykeyspace.bookcatalog.model.Book;

import java.util.List;

/**
 * Interface describes DAO layer for Book entity
 */
public interface BookDAO {

    /**
     * Load list of all Book objects from DB
     *
     * @return List of Book objects
     */
    List<Book> loadAll();

    /**
     * Find Book object by ID from DB
     *
     * @param id - book ID in DB
     * @return Book object
     */
    Book findByNumber(Integer id) throws NoSuchIdException;

    /**
     * Save Book object in DB
     *
     * @param book - Book object
     */
    void save(Book book);

    /**
     * Update Book object in DB
     *
     * @param book - Book object
     */
    void update(Book book);
}

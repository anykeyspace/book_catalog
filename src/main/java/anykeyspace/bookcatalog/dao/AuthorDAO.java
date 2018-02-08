package anykeyspace.bookcatalog.dao;

import anykeyspace.bookcatalog.model.Author;

import java.util.List;

/**
 * Interface describes DAO layer for Author entity
 */
public interface AuthorDAO {

    /**
     * Load list of all Author objects from DB
     *
     * @return
     */
    List<Author> loadAll();

    /**
     * Save Author object in DB
     *
     * @param author
     */
    void save(Author author);
}

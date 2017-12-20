package anykeyspace.bookcatalog.dao;

import anykeyspace.bookcatalog.model.Author;

import java.util.List;

public interface AuthorDAO {

    /**
     * Получить все объекты Author
     *
     * @return
     */
    List<Author> loadAll();

    /**
     * Сохранить Author
     *
     * @param author
     */
    void save(Author author);
}

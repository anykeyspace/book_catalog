package anykeyspace.bookcatalog.dao;


import anykeyspace.bookcatalog.model.Book;

import java.util.List;

public interface BookDAO {

    /**
     * Получить все объекты Book
     *
     * @return
     */
    List<Book> loadAll();

    /**
     * Сохранить Book
     *
     * @param book
     */
    void save(Book book);
}

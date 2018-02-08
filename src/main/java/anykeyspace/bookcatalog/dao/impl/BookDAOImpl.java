package anykeyspace.bookcatalog.dao.impl;

import anykeyspace.bookcatalog.dao.BookDAO;
import anykeyspace.bookcatalog.exception.NoSuchIdException;
import anykeyspace.bookcatalog.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class BookDAOImpl implements BookDAO {

    private final EntityManager entityManager;

    @Autowired
    public BookDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> loadAll() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    @Override
    public Book findByNumber(Integer bookNumber) throws NoSuchIdException {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.bookNumber LIKE :book_number", Book.class)
                .setParameter("book_number", bookNumber);

        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Book book) {
        Book persistedBook = findByNumber(book.getBookNumber());
        persistedBook.setName(book.getName());
        persistedBook.setAuthor(book.getAuthor());
        persistedBook.setGenre(book.getGenre());
        persistedBook.setYear(book.getYear());
        persistedBook.setDescription(book.getDescription());
        entityManager.flush();
    }
}

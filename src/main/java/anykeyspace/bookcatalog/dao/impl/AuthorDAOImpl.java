package anykeyspace.bookcatalog.dao.impl;

import anykeyspace.bookcatalog.dao.AuthorDAO;
import anykeyspace.bookcatalog.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class AuthorDAOImpl implements AuthorDAO {

    private final EntityManager entityManager;

    @Autowired
    public AuthorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Author> loadAll() {
        TypedQuery<Author> query = entityManager.createQuery("SELECT a FROM Author a", Author.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Author author) {
        entityManager.persist(author);
    }
}

package anykeyspace.bookcatalog.service.impl;

import anykeyspace.bookcatalog.dao.AuthorDAO;
import anykeyspace.bookcatalog.model.Author;
import anykeyspace.bookcatalog.service.AuthorService;
import anykeyspace.bookcatalog.service.ViewConverter;
import anykeyspace.bookcatalog.view.AuthorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAO dao;

    @Autowired
    public AuthorServiceImpl(AuthorDAO dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addAuthor(AuthorView view) {
        Author author = ViewConverter.authorFromView(view);
        dao.save(author);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<AuthorView> loadAllAuthors() {
        List<Author> authorList = dao.loadAll();

        return authorList.stream()
                .map(ViewConverter::authorToView)
                .collect(Collectors.toList());
    }
}

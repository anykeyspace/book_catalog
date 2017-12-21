package anykeyspace.bookcatalog.service.impl;

import anykeyspace.bookcatalog.dao.AuthorDAO;
import anykeyspace.bookcatalog.model.Author;
import anykeyspace.bookcatalog.service.AuthorService;
import anykeyspace.bookcatalog.view.AuthorView;
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
    @Transactional(readOnly = true)
    public List<AuthorView> loadAllAuthors() {
        List<Author> authorList = dao.loadAll();

        Function<Author, AuthorView> mapAuthor = author -> {
            AuthorView view = new AuthorView();
            view.setFirstName(author.getFirstName());
            view.setLastName(author.getLastName());
            view.setCountry(author.getCountry());
//            view.setBooks();
            return view;
        };

        return authorList.stream()
                .map(mapAuthor)
                .collect(Collectors.toList());
    }
}

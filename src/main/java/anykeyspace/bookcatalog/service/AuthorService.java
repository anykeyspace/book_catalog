package anykeyspace.bookcatalog.service;

import anykeyspace.bookcatalog.view.AuthorView;

import java.util.List;

/**
 * Author service
 */
public interface AuthorService {

    /**
     * Author add method
     *
     * @param view
     */
    void addAuthor(AuthorView view);

    /**
     * All authors load method
     *
     * @return
     */
    List<AuthorView> loadAllAuthors();
}

package se.lexcicon.rajashree.dao;

import se.lexcicon.rajashree.entity.AppUser;
import se.lexcicon.rajashree.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {

    Optional<Author> findById(int id);

    List<Author> findAll();

    Author create(Author author);

    Author update(Author author);

    void detete(int id);
}

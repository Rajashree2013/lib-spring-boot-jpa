package se.lexcicon.rajashree.dao;

import se.lexcicon.rajashree.entity.AppUser;
import se.lexcicon.rajashree.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    Optional<Book> findById(int id);
    List<Book> findAll();
    Book create (Book book);
    Book update(Book book);
    void delete (int id);
}

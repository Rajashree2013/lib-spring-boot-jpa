package se.lexcicon.rajashree.dao;

import se.lexcicon.rajashree.entity.Book;
import se.lexcicon.rajashree.entity.BookLoan;

import java.util.List;
import java.util.Optional;

public interface BookLoanDao {

    Optional<BookLoan> findById(int id);
    List<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(int id);
}

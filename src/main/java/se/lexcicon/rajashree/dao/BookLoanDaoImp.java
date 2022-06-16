package se.lexcicon.rajashree.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexcicon.rajashree.entity.Book;
import se.lexcicon.rajashree.entity.BookLoan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
@Repository
public class BookLoanDaoImp implements BookLoanDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<BookLoan> findById(int id) {
        return Optional.ofNullable(entityManager.find(BookLoan.class, id));
    }

    @Override
    public List<BookLoan> findAll() {
        return entityManager.createQuery("Select a from BookLoan a").getResultList();
    }

    @Override
    public BookLoan create(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    public void delete(int id) {
        findById(id).orElseThrow(() -> new IllegalArgumentException("Data not found Exception"));
        entityManager.remove(id);

    }
}

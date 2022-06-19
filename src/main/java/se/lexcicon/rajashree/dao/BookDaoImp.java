package se.lexcicon.rajashree.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexcicon.rajashree.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDaoImp implements BookDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<Book> findById(int id) {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    @Override
    public List<Book> findAll() {

        return entityManager.createQuery("Select a from Book a").getResultList();
    }

    @Override
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Override
    public void delete(int id) {
        findById(id).orElseThrow(() -> new IllegalArgumentException("Data not found Exception"));
        entityManager.remove(id);

    }
}

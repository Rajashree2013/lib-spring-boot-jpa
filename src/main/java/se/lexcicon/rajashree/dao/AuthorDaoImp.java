package se.lexcicon.rajashree.dao;

import se.lexcicon.rajashree.entity.AppUser;
import se.lexcicon.rajashree.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class AuthorDaoImp implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<Author> findById(int id) {
        return Optional.ofNullable(entityManager.find(Author.class, id));
    }

    @Override
    public List<Author> findAll() {

        return entityManager.createQuery("Select a from Author a").getResultList();
    }

    @Override
    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public Author update(Author author) {
        return entityManager.merge(author);
    }

    @Override
    public void detete(int id) {
        findById(id).orElseThrow(() -> new IllegalArgumentException("Data not found Exception"));
        entityManager.remove(id);

    }
}

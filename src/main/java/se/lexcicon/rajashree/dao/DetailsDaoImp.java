package se.lexcicon.rajashree.dao;

import org.springframework.transaction.annotation.Transactional;
import se.lexcicon.rajashree.entity.AppUser;
import se.lexcicon.rajashree.entity.Details;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class DetailsDaoImp implements DetailsDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<Details> findById(int id) {
        return Optional.ofNullable(entityManager.find(Details.class, id));

    }
    @Override
    public List<Details> findAll() {
        return entityManager.createQuery("Select a from Details a").getResultList();
    }

    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override

    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    @Transactional
    public void detete(int id) {
        findById(id).orElseThrow(() -> new IllegalArgumentException("Data not found Exception"));
        entityManager.remove(id);
    }
}

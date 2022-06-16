package se.lexcicon.rajashree.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexcicon.rajashree.entity.AppUser;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
@Repository
public class AppUserDaoImp implements AppUserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<AppUser> findById(int id) {
        return Optional.ofNullable(entityManager.find(AppUser.class, id));
    }

    @Override
    public List<AppUser> findAll() {

        return entityManager.createQuery("Select a from AppUser a").getResultList();
    }

    @Override
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    @Transactional
    public void detete(int id) {
        findById(id).orElseThrow(() -> new IllegalArgumentException("Data not found Exception"));
        entityManager.remove(id);
    }
}

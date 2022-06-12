package se.lexcicon.rajashree.dao;

import se.lexcicon.rajashree.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserDao {

    Optional<AppUser> findById(int id);

    List <AppUser> findAll();
   AppUser create (AppUser appUser);
   AppUser update(AppUser appUser);
   void detete (int id);






}

package se.lexcicon.rajashree.dao;

import se.lexcicon.rajashree.entity.AppUser;
import se.lexcicon.rajashree.entity.Details;

import java.util.List;
import java.util.Optional;

public interface DetailsDao {

    Optional<Details> findById(int id);

    List<Details> findAll();

    Details create(Details details);

    Details update(Details details);

    void detete(int id);
}

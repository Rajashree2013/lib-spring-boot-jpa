package se.lexcicon.rajashree.model;

import javax.persistence.Column;
import java.time.LocalDate;

public class AppUser {
    @Column(nullable = false, length = 100)
 private int appuser;
    @Column(nullable = false, length = 100)
 private String username;
    @Column(nullable = false, length = 100)
private String password;
    @Column(nullable = false)
private LocalDate regDate;
    @Column(nullable = false, length = 100)
private Details  userDetails;


}

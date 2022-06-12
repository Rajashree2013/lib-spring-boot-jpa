package se.lexcicon.rajashree.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Details {


    @Id // primary key for id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // means auto_increment
    private   int detailId;

    @Column(nullable = false, length = 100) // not null varchar(100)
    private String email;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    LocalDate birthDate;

    //default constructor
    public Details() {
    }

    //paramatrized construtor without Id

    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
   //  //paramatrized construtor with Id
   public Details(int detailId, String email, String name, LocalDate birthDate) {
       this.detailId = detailId;
       this.email = email;
       this.name = name;
       this.birthDate = birthDate;

   }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;

    }



    @Override
    public String toString() {
        return "Details{" +
                "detailId=" + detailId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

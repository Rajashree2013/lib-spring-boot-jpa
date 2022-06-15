package se.lexcicon.rajashree.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class AppUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(updatable = false)
    private int appUserId;

    @Column(nullable = false, length = 100)
    private String userName;

    @Column(nullable = false, length = 100)
    private String password;


    @Column(nullable = false)
    private LocalDate regDate;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "userDetails_detailId", referencedColumnName = "detailId")
    private Details userDetails;



    @OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY)
    private List<BookLoan> loans;

    //default constructor
    public AppUser() {
    }
    //paramatrized construtor with Id
    public AppUser(int appUserId, String userName, String password, LocalDate regDate, Details userDetails) {
        this.appUserId = appUserId;
        this.userName = userName;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }
    //paramatrized construtor without Id
    public AppUser(String userName, String password, LocalDate regDate, Details userDetails) {
        this.userName = userName;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
    }

    public AppUser(int appUserId, String userName, String password, LocalDate regDate) {
        this.appUserId = appUserId;
        this.userName = userName;
        this.password = password;
        this.regDate = regDate;
    }

    public AppUser(String userName, String password, LocalDate regDate) {
        this.userName = userName;
        this.password = password;
        this.regDate = regDate;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

    public List<BookLoan> getLoans() {
        return loans;
    }

    public void setLoans(List<BookLoan> loans) {
        this.loans = loans;
    }

    public void loanBook(BookLoan bookLoan) {
        if (bookLoan == null) throw new IllegalArgumentException("bookLoan data is null");
        if (loans == null) loans = new ArrayList<>();
        loans.add(bookLoan);
        bookLoan.setBorrower(this);
    }

    public void returnBook(BookLoan bookLoan) {
        if (bookLoan == null) throw new IllegalArgumentException("bookLoan data is null");
        if (loans != null) {
            bookLoan.setBook(null);
            loans.remove(bookLoan);
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return getAppUserId() == appUser.getAppUserId() && getUserName().equals(appUser.getUserName()) && getPassword().equals(appUser.getPassword()) && getRegDate().equals(appUser.getRegDate()) && getUserDetails().equals(appUser.getUserDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAppUserId(), getUserName(), getPassword(), getRegDate(), getUserDetails());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", userDetails=" + userDetails +
                '}';
    }
}

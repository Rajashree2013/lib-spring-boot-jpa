package se.lexcicon.rajashree.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class BookLoan {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;

    @Column(nullable = false)
    private LocalDate loanDate;

    @Column(nullable = false)
    private LocalDate dueDate;


    private boolean returned;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "bookId")
    private Book book;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "appUserId")
    private AppUser borrower;

    public BookLoan() {
    }

    public BookLoan(LocalDate loanDate, LocalDate dueDate, boolean returned, Book book, AppUser borrower) {
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.book = book;
        this.borrower = borrower;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public AppUser getBorrower() {
        return borrower;
    }

    public void setBorrower(AppUser borrower) {
        this.borrower = borrower;
    }

    @Override
    public String toString() {
        return "bookLoan{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                ", book=" + book +
                ", borrower=" + borrower +
                '}';
    }
}

package se.lexcicon.rajashree.entity;

import antlr.collections.List;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(updatable = false)
    private int authorId;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @ManyToMany
    @JoinTable(name = "book_written",
            joinColumns = @JoinColumn(name = "authorId"),
            inverseJoinColumns = @JoinColumn(name = "bookId")
    )
    private Set<Book> writtenBooks;

    public Author() {
    }

    public Author(String firstName, String lastName, Set<Book> writtenBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
    }
    public Author(int authorId, String firstName, String lastName, Set<Book> writtenBooks) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(Set<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return getAuthorId() == author.getAuthorId() && getFirstName().equals(author.getFirstName()) && getLastName().equals(author.getLastName()) && getWrittenBooks().equals(author.getWrittenBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorId(), getFirstName(), getLastName(), getWrittenBooks());
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", writtenBooks=" + writtenBooks +
                '}';
    }
}








package se.lexcicon.rajashree.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexcicon.rajashree.dao.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineRunnerExample implements CommandLineRunner {

    AppUserDao appUserDao;
    AuthorDao authorDao;
    BookDao bookDao;
    BookLoanDao bookLoanDao;
    DetailsDao detailsDao;
    @Autowired
    public CommandLineRunnerExample(AppUserDao appUserDao, AuthorDao authorDao, BookDao bookDao, BookLoanDao bookLoanDao, DetailsDao detailsDao) {
        this.appUserDao = appUserDao;
        this.authorDao = authorDao;
        this.bookDao = bookDao;
        this.bookLoanDao = bookLoanDao;
        this.detailsDao = detailsDao;

    }


@Transactional
    @Override
    public void run(String... args) throws Exception {


    Details details1 = new Details("raj.b@gmail.com","Rajashree",LocalDate.parse("1989-02-27"));
    Details details2 = new Details("raj.k@gmail.com","RAJU",LocalDate.parse("1989-02-27"));
    Details createdDetailsRow1 =detailsDao.create(details1);
    Details createdDetailsRow2 =detailsDao.create(details2);
    AppUser appUser1 = new AppUser ("Rajashree","Raj123", LocalDate.parse("1989-02-27"),createdDetailsRow1);
    AppUser appUser2 = new AppUser ("Raj","Raj1234", LocalDate.parse("1989-02-27"),createdDetailsRow2);

    Book insertedBookRowJavaSE = bookDao.create(new Book("978–1–940313–09–2","JAVA",20));
    Book insertedBookRowJavaEE = bookDao.create(new Book("978–1–940313–09–3","JAVA EE",20));
    Book insertedBookRowSpring = bookDao.create(new Book("978–1–940313–09–4","SPRING",20));
    Book insertedBookRowJPA = bookDao.create(new Book("978–1–940313–09–5","HIBERNATE",20));

    Set<Book> books = new HashSet<>();
    Set<Book> books2 = new HashSet<>();
    books.add(insertedBookRowJavaSE);
    books.add(insertedBookRowJavaEE);
    books2.add(insertedBookRowSpring);
    books2.add(insertedBookRowJPA);
    Author insertedAutorRow1 = authorDao.create(new Author("Evan", "Ken", books));
    Author insertedAutorRow2 = authorDao.create(new Author("Evan", "Vir", books2));

    Set<Author> author1 = new HashSet<>();
    author1.add(insertedAutorRow1);

    Set<Author> author2 = new HashSet<>();
    author2.add(insertedAutorRow2);

    insertedBookRowJPA.setAuthors(author1);
    insertedBookRowSpring.setAuthors(author2);




    BookLoan bookloan1 = new BookLoan(LocalDate.parse("1989-02-27"),LocalDate.parse("1989-02-27"),false,insertedBookRowJavaSE,appUser1);
    BookLoan bookloan2 = new BookLoan(LocalDate.parse("1989-02-27"),LocalDate.parse("1989-02-27"),true,insertedBookRowJavaEE,appUser2);

    BookLoan bookloanRow1 = bookLoanDao.create(bookloan1);
    BookLoan bookloanRow2 = bookLoanDao.create(bookloan2);






    }
}

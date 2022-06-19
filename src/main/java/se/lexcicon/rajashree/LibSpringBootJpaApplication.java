package se.lexcicon.rajashree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.metrics.ApplicationStartup;

@SpringBootApplication
public class LibSpringBootJpaApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(LibSpringBootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System . out . println ( " Application Started !! " );
    }
}

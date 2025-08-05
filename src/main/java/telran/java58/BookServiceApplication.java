package telran.java58;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import telran.java58.book.dao.BookRepository;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {

    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.addBooks();

    }
}

package telran.java58.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java58.book.model.Publisher;

import java.util.stream.Stream;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
    Stream<Publisher> findDistinctByBooksAuthorsAuthorNameIgnoreCase(String authorName);
}

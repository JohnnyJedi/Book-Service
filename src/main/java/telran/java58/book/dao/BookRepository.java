package telran.java58.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java58.book.model.Book;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<Book, String> {

    Set<Book> findAllByAuthorsAuthorName(String authorName);

    Stream<Book> findAllByPublisherPublisherName(String publisherName);

    void deleteByAuthorsAuthorNameIgnoreCase(String authorName);
}

package telran.java58.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java58.book.model.Book;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, String> {

    Set<Book> findAllByAuthorsAuthorName(String authorName);

    List<Book> findAllByPublisher_PublisherName(String publisherPublisherName);

    void deleteByAuthorsAuthorNameIgnoreCase(String authorName);
}

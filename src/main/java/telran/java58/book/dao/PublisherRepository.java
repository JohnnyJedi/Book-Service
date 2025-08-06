package telran.java58.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import telran.java58.book.model.Publisher;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, String> {

    @Query("select distinct p.publisherName from Book b join b.publisher p join  b.authors a  where  a.authorName=?1")
    List<String> findPublisherByAuthor(String publisherName);
}

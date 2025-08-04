package telran.java58.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java58.book.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String> {

}

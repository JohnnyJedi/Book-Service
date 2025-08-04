package telran.java58.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.java58.book.model.Author;

public interface AuthorRepository extends JpaRepository <Author, String> {

}

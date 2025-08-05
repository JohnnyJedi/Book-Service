package telran.java58.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = "isbn")
@Builder
public class Book {
    @Id
    private String isbn;
    private String title;
    @Singular
    @ManyToMany  //(fetch = FetchType.EAGER)
    private Set<Author> authors;

}

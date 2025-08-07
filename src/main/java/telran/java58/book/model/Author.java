package telran.java58.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = "fullName")
@Builder
public class Author {
    @Id
    private String fullName;
    @Singular
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author(String fullName) {
        this.fullName = fullName;
    }
}

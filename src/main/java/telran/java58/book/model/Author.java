package telran.java58.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
@EqualsAndHashCode(of = "authorName")
public class Author {
    @Id
    @Column(name = "author_name")
    private String authorName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author(String authorName, LocalDate birthDate) {
        this.authorName = authorName;
        this.birthDate = birthDate;
    }
}

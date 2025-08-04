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
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "title")
    private String title;
    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_name"))
    private Set<Author> authors;
    @ManyToOne
    @JoinColumn(name = "publisher_name")
    private Publisher publisher;
}

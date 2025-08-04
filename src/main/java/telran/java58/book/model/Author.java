package telran.java58.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
}

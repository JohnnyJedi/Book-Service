package telran.java58.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "publisherName")
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @Column(name = "publisher_name")
    String publisherName;
    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return publisherName;
    }
}

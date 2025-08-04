package telran.java58.book.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    @JsonProperty("name")
    private String authorName;
    private LocalDate birthDate;
}

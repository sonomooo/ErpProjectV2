package book.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    @Size(max = 255, message = "255자 이하로 입력하세요")
    String title;

    @Size(max = 100, message = "100자 이하로 입력하세요")
    String author;

    @Size(max = 50, message = "50자 이하로 입력하세요")
    String category;

    //String created_at;
}

package book.bookDto;

import jakarta.validation.constraints.Size;

public record BookRequest(
                String title,
                String author,
                String category) {
}

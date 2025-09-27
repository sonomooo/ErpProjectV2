package book.bookDto;

import lombok.Builder;

@Builder
public record BookResponse(Long Id,
                           String title,
                           String author,
                           String category) {
}

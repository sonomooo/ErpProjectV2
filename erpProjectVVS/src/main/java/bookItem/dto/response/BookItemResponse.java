package bookItem.dto.response;

import com.example.chackchack.domain.book.entity.Book;
import lombok.Builder;

@Builder
public record BookItemResponse (Long id,
                                Book book,
                                int volume,
                                String serial,
                                String isbn){
}

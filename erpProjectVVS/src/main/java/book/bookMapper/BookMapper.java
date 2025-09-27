package book.bookMapper;

import book.bookDto.BookRequest;
import book.bookDto.BookResponse;
import book.domain.Book;
import org.springframework.data.domain.Page;
import realERPproject.erpProjectVVS.product.dto.response.ProductResponse;

public class BookMapper {

    public Book toEntity(BookRequest bookRequest){

        return Book.builder()
                .title(bookRequest.title())
                .author(bookRequest.author())
                .category(bookRequest.category())
                .build();
    }

    public BookResponse toResponse(Book book){

        return BookResponse.builder().build();
    }

    public Book toUpdate(Long bookId, BookRequest bookRequest){

        return Book.builder()
                .Id(bookId)
                .title(bookRequest.title())
                .author(bookRequest.author())
                .category(bookRequest.category())
                .build();
    }

    public Page<BookResponse> BookPageToResponse(Page<Book> books){

        return books.map(book ->
                BookResponse.builder()
                        .Id(book.getId())
                        .title(book.getTitle())
                        .author(book.getAuthor())
                        .category(book.getCategory())
                        .build());
    }
}

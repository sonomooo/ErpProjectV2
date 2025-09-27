package book.controller;

import book.bookDto.BookRequest;
import book.bookDto.BookResponse;
import book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import realERPproject.erpProjectVVS.product.dto.response.ProductResponse;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    public BookResponse createBook(@RequestBody BookRequest bookRequest){

        return bookService.createBook(bookRequest);

    }

    //patch로 변경
    @PostMapping("/update")
    public BookResponse updateBook(@RequestBody BookRequest bookRequest,
                                                   @RequestParam Long bookId){

        return bookService.updateBook(bookId, bookRequest);
    }

    //리스트로 찾기
    @GetMapping()
    public Page<BookResponse> findBooks(@PathVariable("keyword") String keyword,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size
    ){
        Page<BookResponse> getBookList = bookService.findBookList(keyword, page, size);

        return getBookList;
    }

    @GetMapping
    public BookResponse findBook(@PathVariable("keyword") Long bookId
    ){
        return bookService.findBook(bookId);
    }

    @DeleteMapping("/bookId")
    public void deleteBook(@PathVariable("Id") Long bookId){

        bookService.deleteBook(bookId);

    }
}

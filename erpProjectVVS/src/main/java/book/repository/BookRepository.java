package book.repository;

import book.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

    Page<Book> findByBookTitleContaining(String keyWord, PageRequest pageRequest);

}

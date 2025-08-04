package telran.java58.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.java58.book.dto.AuthorDto;
import telran.java58.book.dto.BookDto;
import telran.java58.book.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/book")
    public void addBook(@RequestBody BookDto book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/book/{isbn}")
    public BookDto deleteBook(@PathVariable String isbn) {
        return bookService.deleteBook(isbn);
    }

    @PatchMapping("/book/{isbn}/title/{title}")
    public BookDto updateBookTitle(@PathVariable String isbn, @PathVariable String title) {
        return bookService.updateBookTitle(isbn, title);
    }

    @GetMapping("/book/{isbn}")
    public BookDto getBook(@PathVariable String isbn) {
        return bookService.getBook(isbn);
    }

    @GetMapping("/books/author/{authorName}")
    public Iterable<BookDto> findBooksByAuthor(@PathVariable String authorName) {
        return bookService.findBooksByAuthor(authorName);
    }

    @GetMapping("/books/publisher/{publisherName}")
    public Iterable<BookDto> findBooksByPublisher(@PathVariable String publisherName) {
        return bookService.findBooksByPublisher(publisherName);
    }

    @GetMapping("/authors/book/{isbn}")
    public Iterable<AuthorDto> findBookAuthors(@PathVariable String isbn) {
        return bookService.findBookAuthors(isbn);
    }

    @GetMapping("/publishers/author/{authorName}")
    public Iterable<String> findPublishersByAuthor(@PathVariable String authorName) {
        return bookService.findPublishersByAuthor(authorName);
    }

    @DeleteMapping("/author/{authorName}")
    public AuthorDto removeAuthor(@PathVariable String authorName) {
        return bookService.removeAuthor(authorName);
    }
}

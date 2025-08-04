package telran.java58.book.service;

import telran.java58.book.dto.AuthorDto;
import telran.java58.book.dto.BookDto;

public interface BookService {
    void addBook(BookDto book);

    BookDto deleteBook(String isbn);

    BookDto updateBookTitle(String isbn, String title);

    BookDto getBook(String isbn);

    Iterable<BookDto> findBooksByAuthor(String authorName);

    Iterable<BookDto> findBooksByPublisher(String publisherName);

    Iterable<AuthorDto> findBookAuthors(String isbn);

    Iterable<String> findPublishersByAuthor(String authorName);

    AuthorDto removeAuthor(String authorName);

}

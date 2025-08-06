package telran.java58.book.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import telran.java58.book.dao.AuthorRepository;
import telran.java58.book.dao.BookRepository;
import telran.java58.book.dao.PublisherRepository;
import telran.java58.book.dto.AuthorDto;
import telran.java58.book.dto.BookDto;
import telran.java58.book.dto.exceptions.EntityExistsException;
import telran.java58.book.dto.exceptions.NotFoundException;
import telran.java58.book.model.Author;
import telran.java58.book.model.Book;
import telran.java58.book.model.Publisher;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public void addBook(BookDto bookDto) {
        if (bookRepository.existsById(bookDto.getIsbn())) {
            throw new EntityExistsException();
        }
        // Publisher
        Publisher publisher = publisherRepository.findById(bookDto.getPublisher().getPublisherName())
                .orElseGet(() -> publisherRepository.save(new Publisher(bookDto.getPublisher().getPublisherName())));
        // Authors
        Set<Author> authors = bookDto.getAuthors().stream()
                .map(a -> authorRepository.findById(a.getAuthorName()).orElseGet(() -> authorRepository.save(new Author(a.getAuthorName(), a.getBirthDate()))))
                .collect(Collectors.toSet());
        Book book = new Book(bookDto.getIsbn(), bookDto.getTitle(), authors, publisher);
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public BookDto deleteBook(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(NotFoundException::new);
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        bookRepository.delete(book);
        return bookDto;
    }

    @Override
    @Transactional
    public BookDto updateBookTitle(String isbn, String title) {
        Book book = bookRepository.findById(isbn).orElseThrow(NotFoundException::new);
        book.setTitle(title);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public BookDto getBook(String isbn) {
        return modelMapper.map(bookRepository.findById(isbn).orElseThrow(NotFoundException::new), BookDto.class);
    }

    @Override
    public Iterable<BookDto> findBooksByAuthor(String authorName) {
        Author author = authorRepository.findById(authorName).orElseThrow(NotFoundException::new);
        Set<Book> books = bookRepository.findAllByAuthorsAuthorName(authorName);
        return books.stream().map(b -> modelMapper.map(b, BookDto.class)).collect(Collectors.toSet());
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<BookDto> findBooksByPublisher(String publisherName) {
        Publisher publisher = publisherRepository.findById(publisherName).orElseThrow(NotFoundException::new);
        return bookRepository.findAllByPublisherPublisherName(publisherName).map(b -> modelMapper.map(b, BookDto.class)).collect(Collectors.toSet());
    }

    @Override
    public Iterable<AuthorDto> findBookAuthors(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(NotFoundException::new);
        return book.getAuthors().stream().map(a -> modelMapper.map(a, AuthorDto.class)).collect(Collectors.toList());
    }

    @Override
    public Iterable<String> findPublishersByAuthor(String authorName) {
        return publisherRepository.findPublisherByAuthor(authorName);
    }

    @Override
    @Transactional
    public AuthorDto removeAuthor(String authorName) {
        Author author = authorRepository.findById(authorName).orElseThrow(NotFoundException::new);
//        Set<Book> books = bookRepository.findAllByAuthorsAuthorName(authorName);
//        bookRepository.deleteAll(books);
        bookRepository.deleteByAuthorsAuthorNameIgnoreCase(authorName);
        authorRepository.delete(author);
        return modelMapper.map(author, AuthorDto.class);
    }
}

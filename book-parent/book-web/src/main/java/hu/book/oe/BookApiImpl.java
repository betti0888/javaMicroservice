package hu.book.oe;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BookApiImpl implements BookApi {

    private final BookService service;

    public BookApiImpl(BookService service) {
        this.service = service;
    }

    @Override
    public Set<Book> getAll() {
        return service.getAll();
    }

    @Override
    public Book getById(String id) {
        try {
            return service.getById(id);
        } catch (BookNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Book updateById(String id, Book book) {
        try {
            return service.update(id, book);
        } catch (BookNotFound | PublisherNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Book create(Book book) {
        try {
            return service.create(book);
        } catch (PublisherNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }

}

package hu.book.oe;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;
    private final PublisherRepository pRepository;
    private final BookMapper mapper;

    public BookService(BookRepository repository, PublisherRepository pRepository,
            BookMapper mapper) {
        this.repository = repository;
        this.pRepository = pRepository;
        this.mapper = mapper;
    }

    public Set<Book> getAll() {
       return repository.findAll().stream().map(mapper::map).collect(Collectors.toSet());
    }
    

    public Book getById(String id) throws BookNotFound {
        return repository.findById(id).map(mapper::map).orElseThrow(BookNotFound::new);
    }

    public Book update(String id, Book book) throws BookNotFound, PublisherNotFound {

        var opt = repository.findById(id);

        if (opt.isEmpty()) {
            throw new BookNotFound();
        }
        var entity = opt.get();
        update(entity, book);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public Book create(Book book) throws PublisherNotFound {
        var entity = new BookEntity();
        entity.setIsbn(book.getIsbn());
        entity.setBookAuthor(book.getBookAuthor());
        entity.setBookTitle(book.getBookTitle());
        entity.setImageUrl(book.getImageUrl());

        var publisher = pRepository.findById(book.getPublisherId()).orElseThrow(PublisherNotFound::new);

        entity.setPublisher(publisher);
        entity.setYearOfPublication(book.getYearOfPublication());

        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private void update(BookEntity entity, Book book) throws PublisherNotFound {
        entity.setIsbn(entity.getIsbn());
        entity.setBookAuthor(entity.getBookAuthor());
        entity.setBookTitle(entity.getBookTitle());
        entity.setImageUrl(entity.getImageUrl());
        
        var publisher = pRepository.findById(book.getPublisherId()).orElseThrow(PublisherNotFound::new);
        
        entity.setPublisher(publisher);
        entity.setYearOfPublication(entity.getYearOfPublication());
    }

}

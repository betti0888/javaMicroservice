package hu.book.oe;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final RatingRepository repository;
    private final BookRepository bRepository;
    private final UserRepository uRepository;
    private final RatingMapper mapper;

    public RatingService(RatingRepository repository, BookRepository bRepository,
            UserRepository uRepository, RatingMapper mapper) {
        this.repository = repository;
        this.bRepository = bRepository;
        this.uRepository = uRepository;
        this.mapper = mapper;
    }

    public Set<Rating> getAll() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toSet());
    }

    public Rating getById(String id) throws RatingNotFound {
        return repository.findById(id).map(mapper::map).orElseThrow(RatingNotFound::new);
    }

    public Rating update(String id, Rating rating) throws RatingNotFound, BookNotFound, UserNotFound {
        var opt = repository.findById(id);

        if (opt.isEmpty()) {
            throw new RatingNotFound();
        }
        var entity = opt.get();
        update(entity, rating);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public Rating create(Rating rating) throws BookNotFound, UserNotFound {
        var entity = new RatingEntity();
        entity.setBookRating(rating.getBookRating());
        var book = bRepository.findById(rating.getIsbn()).orElseThrow(BookNotFound::new);
        entity.setBook(book);
        var user = uRepository.findById(rating.getUserId()).orElseThrow(UserNotFound::new);
        entity.setUser(user);
        
        var saved = repository.save(entity);
        
        return mapper.map(saved);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private void update(RatingEntity entity, Rating rating) throws BookNotFound, UserNotFound {
        entity.setBookRating(rating.getBookRating());
        var book = bRepository.findById(rating.getIsbn()).orElseThrow(BookNotFound::new);
        entity.setBook(book);
        var user = uRepository.findById(rating.getUserId()).orElseThrow(UserNotFound::new);
        entity.setUser(user);
    }
}

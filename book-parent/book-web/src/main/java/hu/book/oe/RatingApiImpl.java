package hu.book.oe;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RatingApiImpl implements RatingApi {
    
    private final RatingService service;
    
    public RatingApiImpl(RatingService service) {
        this.service = service;
    }

    @Override
    public Set<Rating> getAll() {
        return service.getAll();
    }

    @Override
    public Rating getById(String id) {
        try {
            return service.getById(id);
        } catch (RatingNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Rating updateById(String id, Rating rating) {
        try {
            return service.update(id, rating);
        } catch (RatingNotFound | BookNotFound | UserNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Rating create(Rating rating) {
        try {
            return service.create(rating);
        } catch (BookNotFound | UserNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }

}

package hu.book.oe;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PublisherApiImpl implements PublisherApi {

    private final PublisherService service;

    public PublisherApiImpl(PublisherService service) {
        this.service = service;
    }

    @Override
    public Set<Publisher> getAll() {
        return service.getAll();
    }

    @Override
    public Publisher getById(String id) {
        try {
            return service.getById(id);
        } catch (PublisherNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Publisher updateById(String id, Publisher publisher) {
        try {
            return service.update(id, publisher);
        } catch (PublisherNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Publisher create(Publisher publisher) {
        return service.create(publisher);
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }

}

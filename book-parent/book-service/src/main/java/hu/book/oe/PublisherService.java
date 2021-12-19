package hu.book.oe;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final PublisherRepository repository;
    private final PublisherMapper mapper;

    public PublisherService(PublisherRepository repository, PublisherMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Set<Publisher> getAll() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toSet());
    }

    public Publisher getById(String id) throws PublisherNotFound {
        return repository.findById(id).map(mapper::map).orElseThrow(PublisherNotFound::new);
    }

    public Publisher update(String id, Publisher publisher) throws PublisherNotFound {
        var opt = repository.findById(id);

        if (opt.isEmpty()) {
            throw new PublisherNotFound();
        }
        var entity = opt.get();
        update(entity, publisher);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public Publisher create(Publisher publisher) {
        var entity = new PublisherEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setPublisherName(publisher.getPublisherName());
        entity.setCountry(publisher.getCountry());
        entity.setCity(publisher.getCity());
        
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
    
    private void update(PublisherEntity entity, Publisher publisher) {
        entity.setPublisherName(publisher.getPublisherName());
        entity.setCountry(publisher.getCountry());
        entity.setCity(publisher.getCity());
    }

}

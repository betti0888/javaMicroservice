package hu.book.oe;

import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api")
public interface PublisherApi {
    
    @GetMapping(value = "/Publisher", produces = MediaType.APPLICATION_JSON_VALUE)
    Set<Publisher> getAll();

    @GetMapping(value = "/Publisher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Publisher getById(@PathVariable(value = "id") String id);

    @PostMapping(value = "/Publisher/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Publisher updateById(@PathVariable(value = "id") String id, @RequestBody Publisher publisher);

    @PutMapping(value = "/Publisher", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Publisher create(@RequestBody Publisher publisher);

    @DeleteMapping(value = "/Publisher/{id}")
    void delete(@PathVariable(value = "id") String id);

}

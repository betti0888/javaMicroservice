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
public interface RatingApi {

    @GetMapping(value = "/Rating", produces = MediaType.APPLICATION_JSON_VALUE)
    Set<Rating> getAll();

    @GetMapping(value = "/Rating/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Rating getById(@PathVariable(value = "id") String id);

    @PostMapping(value = "/Rating/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Rating updateById(@PathVariable(value = "id") String id, @RequestBody Rating rating);

    @PutMapping(value = "/Rating", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Rating create(@RequestBody Rating rating);

    @DeleteMapping(value = "/Rating/{id}")
    void delete(@PathVariable(value = "id") String id);
    
}

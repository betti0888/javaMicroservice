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
public interface UserApi {
    
    @GetMapping(value = "/User", produces = MediaType.APPLICATION_JSON_VALUE)
    Set<User> getAll();

    @GetMapping(value = "/User/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    User getById(@PathVariable(value = "id") String id);

    @PostMapping(value = "/User/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    User updateById(@PathVariable(value = "id") String id, @RequestBody User user);

    @PutMapping(value = "/User", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    User create(@RequestBody User user);

    @DeleteMapping(value = "/User/{id}")
    void delete(@PathVariable(value = "id") String id);

}

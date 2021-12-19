package hu.book.oe;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserApiImpl implements UserApi {

    private final UserService service;

    public UserApiImpl(UserService service) {
        this.service = service;
    }

    @Override
    public Set<User> getAll() {
        return service.getAll();
    }

    @Override
    public User getById(String id) {
        try {
            return service.getById(id);
        } catch (UserNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User updateById(String id, User user) {
        try {
            return service.update(id, user);
        } catch (UserNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User create(User user) {
        return service.create(user);
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }

}

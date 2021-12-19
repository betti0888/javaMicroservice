package hu.book.oe;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Set<User> getAll() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toSet());
    }

    public User getById(String id) throws UserNotFound {
        return repository.findById(id).map(mapper::map).orElseThrow(UserNotFound::new);
    }

    public User update(String id, User user) throws UserNotFound {
        var opt = repository.findById(id);

        if (opt.isEmpty()) {
            throw new UserNotFound();
        }
        var entity = opt.get();
        update(entity, user);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public User create(User user) {
        var entity = new UserEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setAge(user.getAge());
        entity.setFullName(user.getFullName());
        entity.setLocation(user.getLocation());
        entity.setRegistrationDate(user.getRegistrationDate());
        entity.setSex(user.getSex());
        
        
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private void update(UserEntity entity, User user) {
        entity.setAge(user.getAge());
        entity.setFullName(user.getFullName());
        entity.setLocation(user.getLocation());
        entity.setRegistrationDate(user.getRegistrationDate());
        entity.setSex(user.getSex());
    }

}

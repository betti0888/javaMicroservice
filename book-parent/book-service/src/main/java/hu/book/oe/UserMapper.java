package hu.book.oe;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    
    public User map(UserEntity entity) {
        var dto = new User();
        dto.setId(entity.getId());
        dto.setAge(entity.getAge());
        dto.setFullName(entity.getFullName());
        dto.setLocation(entity.getLocation());
        dto.setRegistrationDate(entity.getRegistrationDate());
        dto.setSex(entity.getSex());
        return dto;
    }

}

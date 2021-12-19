package hu.book.oe;

import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {
    
    public Publisher map(PublisherEntity entity) {
        var dto = new Publisher();
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setId(entity.getId());
        dto.setPublisherName(entity.getPublisherName());
        return dto;
    }

}

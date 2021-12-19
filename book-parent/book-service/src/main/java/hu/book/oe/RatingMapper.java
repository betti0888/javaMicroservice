package hu.book.oe;

import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    
    public Rating map(RatingEntity entity) {
        var dto = new Rating();
        dto.setBookRating(entity.getBookRating());
        dto.setId(entity.getId());
        dto.setIsbn(entity.getBook().getIsbn());
        dto.setUserId(entity.getUser().getId());
        return dto;
    }

}

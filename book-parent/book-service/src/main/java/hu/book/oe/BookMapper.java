package hu.book.oe;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    
    public Book map(BookEntity entity) {
        var dto = new Book();
        
        dto.setIsbn(entity.getIsbn());
        dto.setBookAuthor(entity.getBookAuthor());
        dto.setBookTitle(entity.getBookTitle());
        dto.setImageUrl(entity.getImageUrl());
        dto.setPublisherId(entity.getPublisher().getId());
        dto.setYearOfPublication(entity.getYearOfPublication());
        
        return dto;
    }

}

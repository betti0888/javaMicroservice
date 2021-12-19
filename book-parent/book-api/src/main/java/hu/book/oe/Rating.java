package hu.book.oe;

import lombok.Data;

@Data
public class Rating {
    
    private String id;
    private String userId;
    private String isbn;
    private int bookRating;

}

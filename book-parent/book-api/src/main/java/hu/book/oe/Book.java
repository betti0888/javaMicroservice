package hu.book.oe;

import lombok.Data;

@Data
public class Book {
    
    private String isbn;
    private String bookTitle;
    private String bookAuthor;
    private String yearOfPublication;
    private String publisherId;
    private String imageUrl;

}

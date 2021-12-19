package hu.book.oe;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Ratings")
public class RatingEntity {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "isbn")
    private BookEntity book;

    private int bookRating;

}

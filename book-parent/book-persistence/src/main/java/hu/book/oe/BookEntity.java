package hu.book.oe;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Books")
public class BookEntity {

    @Id
    private String isbn;
    private String bookTitle;
    private String bookAuthor;
    private String yearOfPublication;

    @ManyToOne
    @JoinColumn(name = "publisherId", referencedColumnName = "id")
    private PublisherEntity publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RatingEntity> ratings = new HashSet<>();

    private String imageUrl;
}

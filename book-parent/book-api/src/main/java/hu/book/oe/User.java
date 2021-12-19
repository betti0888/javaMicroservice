package hu.book.oe;

import java.util.Date;

import lombok.Data;

@Data
public class User {
    
    private String id;
    private String fullName;
    private String location;
    private int age;
    private int sex;
    private Date registrationDate;

}

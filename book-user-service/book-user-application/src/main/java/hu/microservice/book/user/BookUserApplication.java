package hu.book.oe.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "hu.book.oe")
@ConfigurationPropertiesScan(basePackages = "hu.book.oe")
public class BookUserApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BookUserApplication.class, args);
    }

}

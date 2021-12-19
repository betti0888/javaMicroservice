package hu.book.oe;

import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "/api")
@Tag(name = "Book", description = "The Book API")
public interface BookApi {

    @Operation(summary = "Find all Books", description = "", tags = { "Book" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation.") })
    @GetMapping(value = "/Book", produces = MediaType.APPLICATION_JSON_VALUE)
    Set<Book> getAll();

    @Operation(summary = "Find Book by id", description = "", tags = { "Book" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation."),
            @ApiResponse(responseCode = "404", description = "Book not found.") })
    @GetMapping(value = "/Book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Book getById(@PathVariable(value = "id") String id);

    @Operation(summary = "Update Book by id", description = "", tags = { "Book" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation."),
            @ApiResponse(responseCode = "404", description = "Book not found.") })
    @PostMapping(value = "/Book/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Book updateById(@PathVariable(value = "id") String id, @RequestBody Book book);

    @Operation(summary = "Create new book", description = "", tags = {
            "Book" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation.") })
    @PutMapping(value = "/Book", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Book create(@RequestBody Book book);

    @Operation(summary = "Delete Book by id", description = "", tags = { "Book" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation.") })
    @DeleteMapping(value = "/Book/{id}")
    void delete(@PathVariable(value = "id") String id);

}

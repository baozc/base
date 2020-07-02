package com.graphql.demo.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.demo.entity.Author;
import com.graphql.demo.entity.Book;
import com.graphql.demo.model.BookInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


/**
 * Created by genghz on 18/3/29.
 */
@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {


    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return author;
    }

    public Book newBook(String title, String isbn, int pageCount, long authorId) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount);
        book.setAuthorId(authorId);
        return book;
    }

    public Book saveBook(BookInput input) {
        Book book = new Book();
        book.setTitle(input.getTitle());
        book.setIsbn(input.getIsbn());
        book.setPageCount(input.getPageCount());
        book.setAuthorId(input.getAuthorId());
        return book;
    }

    public Boolean deleteBook(long id) {
        return true;
    }

    public Book updateBookPageCount(int pageCount, long id) {

        Book book = new Book();
        book.setPageCount(pageCount);
        book.setId(id);
        return book;
    }
}

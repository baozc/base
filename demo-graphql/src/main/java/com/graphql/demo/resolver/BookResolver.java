package com.graphql.demo.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.demo.entity.Author;
import com.graphql.demo.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by genghz on 18/3/29.
 */
@Component
@AllArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {


    public Author getAuthor(Book book) {

        return null;
    }
}

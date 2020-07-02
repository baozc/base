package com.graphql.demo.resolver;

import java.util.List;
import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.Lists;
import com.graphql.demo.entity.Author;
import com.graphql.demo.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by genghz on 18/3/28.
 */
@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {


    public Author findOneAuthor(Long id) {
        Author a = new Author();
        a.setId(id);

        return a;
    }

    public List<Author> findAllAuthors() {
        return Lists.newArrayList();
    }

    public Long countAuthors() {
        return 1L;
    }

    public List<Book> findAllBooks() {
        return Lists.newArrayList();
    }

    public Long countBooks() {
        return 1L;
    }
}

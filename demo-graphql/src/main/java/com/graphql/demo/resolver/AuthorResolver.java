package com.graphql.demo.resolver;

import java.text.SimpleDateFormat;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.google.common.collect.Lists;
import com.graphql.demo.entity.Author;
import com.graphql.demo.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by genghz on 18/3/29.
 */
@Component
@AllArgsConstructor
public class AuthorResolver implements GraphQLResolver<Author> {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getCreatedTime(Author author) {
        return sdf.format(author.getCreatedTime());
    }

    public List<Book> getBooks(Author author) {
        return Lists.newArrayList();
    }
}

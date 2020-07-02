package com.graphql.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by genghz on 18/3/29.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Book extends BaseEntity {
    private String title;

    private String isbn;

    private int pageCount;

    private long authorId;
}

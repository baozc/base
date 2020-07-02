package com.graphql.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by genghz on 18/3/27.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Author extends BaseEntity {

    private String firstName;

    private String lastName;
}

package com.graphql.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by genghz on 18/3/27.
 */
@Data
public abstract class BaseEntity implements Serializable {

    /* ID */
    protected Long id;

    protected Date createdTime;

    protected Date updatedTime;


    public BaseEntity() {
        createdTime = new Date();
        updatedTime = createdTime;
    }

    private void doPreUpdate() {
        updatedTime = new Date();
    }
}

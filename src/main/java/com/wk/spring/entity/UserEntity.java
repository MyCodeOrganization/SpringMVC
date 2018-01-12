package com.wk.spring.entity;

import lombok.Data;

/**
 * PackageName com.wk.spring.entity
 * Created by wangkang on 2018/1/9.
 */
@Data
public class UserEntity {
    private long id;
    /**
     * name
     */
    private String name;
    /**
     * age
     */
    private int age;
    /**
     * sex 0=女 1=男
     */
    private int sex;

}

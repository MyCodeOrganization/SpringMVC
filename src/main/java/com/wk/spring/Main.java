package com.wk.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * PackageName com.wk.spring
 * Created by wangkang on 2018/1/9.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = {"com.wk.spring"})
@Import(value = {JpaConfig.class})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}

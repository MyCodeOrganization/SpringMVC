package com.wk.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
* ClassName：JpaConfig
* Description：数据库链接配置信息类
* @author auto
* @Date 2017-12-17 14:59:59
* @since JRE 1.6.0_22  or higher
*/
@Configuration
@MapperScan("com.wk.spring.repository")
@PropertySource("classpath:application.properties")
public class JpaConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource mysqlDataSource(){
        return DataSourceBuilder
            .create()
            .build();
    }

}
package com.cn.springboot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {

    @Bean
    JdbcTemplate jdbcTemplateOne(@Qualifier("dataSourceOne")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    JdbcTemplate jdbcTemplateTwo(@Qualifier("dataSourceTwo")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}

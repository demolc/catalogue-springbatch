package com.springbatch.catalogue.reader;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.catalogue.beans.User;

import javax.sql.DataSource;

@Configuration
public class JdbcReaderConfig {

    @Bean
    public JdbcCursorItemReader<User> jdbcCursorItemReader(DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<User>()
            .name("jdbcReader")
            .dataSource(dataSource)
            .sql("SELECT id, name, email FROM user") // Requête SQL
            .rowMapper((rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                return user;
            })
            .build();
    }
}


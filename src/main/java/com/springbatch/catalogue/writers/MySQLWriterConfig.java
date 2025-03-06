package com.springbatch.catalogue.writers;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.catalogue.beans.User;

import javax.sql.DataSource;

@Configuration
public class MySQLWriterConfig {

    @Bean
    public JdbcBatchItemWriter<User> jdbcBatchItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<User>()
            .dataSource(dataSource)
            .sql("INSERT INTO user (name, email) VALUES (:name, :email)") // Requête SQL
            .beanMapped() // Associe les propriétés de l'objet aux colonnes SQL
            .build();
    }
}

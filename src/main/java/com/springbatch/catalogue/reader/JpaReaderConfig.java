package com.springbatch.catalogue.reader;

import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.catalogue.beans.User;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class JpaReaderConfig {

    @Bean
    public JpaPagingItemReader<User> jpaPagingItemReader(EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<User>()
            .name("jpaReader")
            .entityManagerFactory(entityManagerFactory)
            .queryString("SELECT u FROM User u") // Requête JPQL
            .pageSize(10) // Lecture paginée
            .build();
    }
}


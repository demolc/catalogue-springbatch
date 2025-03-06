package com.springbatch.catalogue.writers;

import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.catalogue.beans.User;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class JpaWriterConfig {

    @Bean
    public JpaItemWriter<User> jpaItemWriter(EntityManagerFactory entityManagerFactory) {
        JpaItemWriter<User> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }
}


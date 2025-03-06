package com.springbatch.catalogue.writers;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.catalogue.beans.User;

import java.util.Arrays;

@Configuration
public class CompositeWriterConfig {

    @Bean
    public CompositeItemWriter<User> compositeItemWriter(JdbcBatchItemWriter<User> jdbcWriter, FlatFileItemWriter<User> fileWriter) {
        CompositeItemWriter<User> compositeWriter = new CompositeItemWriter<>();
        compositeWriter.setDelegates(Arrays.asList(jdbcWriter, fileWriter)); // Exécute les deux Writers
        return compositeWriter;
    }
}


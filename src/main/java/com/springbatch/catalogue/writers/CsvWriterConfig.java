package com.springbatch.catalogue.writers;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.catalogue.beans.User;

@Configuration
public class CsvWriterConfig {

    @Bean
    public FlatFileItemWriter<User> csvWriter() {
        return new FlatFileItemWriterBuilder<User>()
            .name("csvWriter")
            .resource(new FileSystemResource("output/users.csv"))
            .delimited()
            .delimiter(";") // Délimiteur CSV
            .names("id", "name", "email") // Colonnes à écrire
            .build();
    }
}


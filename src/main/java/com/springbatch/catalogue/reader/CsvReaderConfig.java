package com.springbatch.catalogue.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.catalogue.beans.User;

@Configuration
public class CsvReaderConfig {

    @Bean
    public FlatFileItemReader<User> csvItemReader() {
        return new FlatFileItemReaderBuilder<User>()
            .name("csvReader")
            .resource(new FileSystemResource("input/users.csv"))
            .delimited()
            .delimiter(";") // Séparateur CSV
            .names("id", "name", "email") // Correspondance des colonnes
            .targetType(User.class) // Convertir en objet User
            .build();
    }
}

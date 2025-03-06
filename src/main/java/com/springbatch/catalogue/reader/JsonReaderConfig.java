package com.springbatch.catalogue.reader;

import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.JsonObjectReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.catalogue.beans.User;

@Configuration
public class JsonReaderConfig {

    @Bean
    public JsonItemReader<User> jsonItemReader() {
        return new JsonItemReaderBuilder<User>()
            .name("jsonReader")
            .resource(new FileSystemResource("input/users.json"))
            .jsonObjectReader(new JacksonJsonObjectReader<>(User.class))
            .build();
    }
}

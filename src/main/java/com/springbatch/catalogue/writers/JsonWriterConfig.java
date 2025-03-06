package com.springbatch.catalogue.writers;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.batch.item.json.JsonObjectMarshaller;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.catalogue.beans.User;

@Configuration
public class JsonWriterConfig {

    @Bean
    public JsonFileItemWriter<User> jsonWriter() {
        return new JsonFileItemWriterBuilder<User>()
            .name("jsonWriter")
            .resource(new FileSystemResource("output/users.json"))
            .jsonObjectMarshaller(new JacksonJsonObjectMarshaller<>()) // Utilise Jackson
            .build();
    }
}

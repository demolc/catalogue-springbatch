package com.springbatch.catalogue.reader;

import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.catalogue.beans.User;

import java.util.List;

@Configuration
public class ListReaderConfig {

    @Bean
    public ListItemReader<User> listItemReader() {
        return new ListItemReader<>(List.of(
            new User(1L, "Alice", "alice@example.com"),
            new User(2L, "Bob", "bob@example.com")
        ));
    }
}

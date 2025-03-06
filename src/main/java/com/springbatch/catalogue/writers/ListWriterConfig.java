package com.springbatch.catalogue.writers;

import org.springframework.batch.item.support.ListItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.catalogue.beans.User;

@Configuration
public class ListWriterConfig {

    @Bean
    public ListItemWriter<User> listItemWriter() {
        return new ListItemWriter<>();
    }
}

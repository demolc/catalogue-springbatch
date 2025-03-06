package com.springbatch.catalogue.reader;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.springbatch.catalogue.beans.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class XmlReaderConfig {

    @Bean
    public StaxEventItemReader<User> xmlItemReader() {
        return new StaxEventItemReaderBuilder<User>()
            .name("xmlReader")
            .resource(new FileSystemResource("input/users.xml"))
            .addFragmentRootElements("user") // Élément XML racine
            .unmarshaller(new Jaxb2Marshaller() {{
                setClassesToBeBound(User.class);
            }})
            .build();
    }
}

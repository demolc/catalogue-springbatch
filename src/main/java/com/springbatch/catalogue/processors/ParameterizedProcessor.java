package com.springbatch.catalogue.processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("step")
public class ParameterizedProcessor implements ItemProcessor<String, String> {
    
    @Value("#{jobParameters['prefix']}")
    private String prefix;

    @Override
    public String process(String item) {
        return prefix + " " + item;
    }
}


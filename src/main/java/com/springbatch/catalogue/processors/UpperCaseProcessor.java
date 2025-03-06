package com.springbatch.catalogue.processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class UpperCaseProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String item) {
        return item.toUpperCase();
    }
}

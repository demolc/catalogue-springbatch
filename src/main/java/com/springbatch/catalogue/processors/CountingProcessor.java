package com.springbatch.catalogue.processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ExecutionContext;

public class CountingProcessor implements ItemProcessor<String, String>, ItemStream {
    private int count = 0;

    @Override
    public String process(String item) {
        count++;
        return "Item " + count + ": " + item;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        count = executionContext.getInt("count", 0);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        executionContext.putInt("count", count);
    }

    @Override
    public void close() throws ItemStreamException {}
}


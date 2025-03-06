package com.springbatch.catalogue.processors;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class AsyncProcessor implements ItemProcessor<String, String> {
    
    @Async
    @Override
    public String process(String item) throws InterruptedException {
        Thread.sleep(1000); // Simule un traitement long
        return "Processed: " + item;
    }
}

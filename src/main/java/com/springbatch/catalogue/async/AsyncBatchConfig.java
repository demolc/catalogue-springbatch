package com.springbatch.catalogue.async;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.integration.async.AsyncItemWriter;
import org.springframework.batch.item.*;

import java.util.concurrent.Future;

@Configuration
public class AsyncBatchConfig {

    @Bean
    public ItemProcessor<String, Future<String>> asyncProcessor(ItemProcessor<String, String> processor) {
    	AsyncItemProcessor<String, String> process = new AsyncItemProcessor<>();
        process.setDelegate(processor);
        process.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return process;
    }

    @Bean
    public ItemWriter<Future<String>> asyncWriter(ItemWriter<String> writer) {
    	AsyncItemWriter asyncItemWriter = new AsyncItemWriter();
        asyncItemWriter.setDelegate(writer);
        return asyncItemWriter;
    }

}

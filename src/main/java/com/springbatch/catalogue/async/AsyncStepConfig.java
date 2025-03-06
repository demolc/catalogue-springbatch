package com.springbatch.catalogue.async;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import org.springframework.batch.core.*;

@Configuration
public class AsyncStepConfig {

    @Bean
    public Step parallelStep(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
                             ItemReader<String> reader,
                             ItemProcessor<String, String> processor,
                             ItemWriter<String> writer) {
        return new StepBuilder("parallelStep", jobRepository)
                .<String, String>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .taskExecutor(new SimpleAsyncTaskExecutor()) // Exécution parallèle
                .build();
    }
}


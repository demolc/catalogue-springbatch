package com.springbatch.catalogue.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("step")
public class ParameterizedTasklet implements Tasklet {

    @Value("#{jobParameters['message']}")
    private String message;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        System.out.println("Message reçu : " + message);
        return RepeatStatus.FINISHED;
    }
}


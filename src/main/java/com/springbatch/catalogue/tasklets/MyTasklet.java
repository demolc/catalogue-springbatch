package com.springbatch.catalogue.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.stereotype.Component;

@Component
public class MyTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        System.out.println("Exécution du Tasklet !");
        return RepeatStatus.FINISHED; // Indique que l'étape est terminée
    }
}
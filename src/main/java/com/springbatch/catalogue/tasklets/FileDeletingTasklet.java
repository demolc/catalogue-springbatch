package com.springbatch.catalogue.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.stereotype.Component;
import java.io.File;

@Component
public class FileDeletingTasklet implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        File file = new File("/path/to/file.txt");
        
        if (file.exists() && file.delete()) {
            System.out.println("Fichier supprimé !");
        } else {
            System.out.println("Fichier introuvable ou suppression échouée.");
        }

        return RepeatStatus.FINISHED;
    }
}

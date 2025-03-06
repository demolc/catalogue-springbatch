package com.springbatch.catalogue.historique;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatchHistoryService implements CommandLineRunner {

    private final JobExplorer jobExplorer;

    public BatchHistoryService(JobExplorer jobExplorer) {
        this.jobExplorer = jobExplorer;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Historique des Jobs Batch ===");

        List<String> jobNames = jobExplorer.getJobNames();
        if (jobNames.isEmpty()) {
            System.out.println("Aucun job batch trouvé.");
            return;
        }

        for (String jobName : jobNames) {
            List<JobInstance> jobInstances = jobExplorer.getJobInstances(jobName, 0, 10);
            for (JobInstance instance : jobInstances) {
                List<JobExecution> executions = jobExplorer.getJobExecutions(instance);
                for (JobExecution execution : executions) {
                    System.out.println("Job: " + execution.getJobInstance().getJobName());
                    System.out.println("Instance ID: " + instance.getInstanceId());
                    System.out.println("Début: " + execution.getStartTime());
                    System.out.println("Fin: " + execution.getEndTime());
                    System.out.println("Statut: " + execution.getStatus());
                    System.out.println("=========================================");
                }
            }
        }
    }
}

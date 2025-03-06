package com.springbatch.catalogue;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParamMain  implements CommandLineRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job myJob;

    public static void main(String[] args) {
        SpringApplication.run(ParamMain.class, args);
    }

    @Override
    public void run(String... args) throws JobExecutionException {
        if (args.length >= 3) {
            // Récupérer les paramètres depuis la ligne de commande
            String param1 = args[0]; // Premier paramètre
            String param2 = args[1]; // Deuxième paramètre
            Integer param3 = Integer.parseInt(args[2]); // Troisième paramètre (entier)

            // Créer les paramètres du job
            JobParameters jobParameters = new JobParametersBuilder()
                .addString("param1", param1) // Ajouter le paramètre 1
                .addString("param2", param2) // Ajouter le paramètre 2
                .addLong("param3", Long.valueOf(param3)) // Ajouter le paramètre 3 (en Long)
                .toJobParameters();

            // Lancer le job avec les paramètres
            jobLauncher.run(myJob, jobParameters);
        } else {
            System.out.println("Veuillez fournir au moins 3 paramètres.");
        }
    }
}

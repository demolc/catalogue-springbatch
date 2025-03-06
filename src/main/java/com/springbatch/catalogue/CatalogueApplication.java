package com.springbatch.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CatalogueApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(CatalogueApplication.class, args)));
	}

}

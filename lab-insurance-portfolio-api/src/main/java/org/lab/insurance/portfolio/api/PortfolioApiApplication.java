package org.lab.insurance.portfolio.api;

import org.lab.insurance.portfolio.common.populator.PortfolioModulePopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApiApplication.class, args);
	}

	@Autowired
	private PortfolioModulePopulator populator;

	@Override
	public void run(String... args) throws Exception {
		if (!populator.isInitialized()) {
			populator.initialize();
		}
	}

}

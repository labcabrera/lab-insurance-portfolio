package org.lab.insurance.portfolio.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan("org.lab.insurance.portfolio.core")
@EnableMongoRepositories({ "org.lab.insurance.portfolio.common.repository" })
public class PortfolioCoreConfig {

}

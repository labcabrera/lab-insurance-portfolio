package org.lab.insurance.portfolio.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan
@EnableMongoRepositories("org.lab.insurance.portfolio.common.repository")
@EnableAutoConfiguration
public class PortfolioCommonConfiguration {

}

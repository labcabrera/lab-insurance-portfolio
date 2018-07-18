package org.lab.insurance.portfolio.api.config;

import org.lab.insurance.portfolio.common.PortfolioCommonConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(PortfolioCommonConfiguration.class)
public class PortfolioApiConfiguration {

}

package org.lab.insurance.portfolio.api.config;

import org.lab.insurance.portfolio.api.IntegrationConstants.Channels;
import org.lab.insurance.portfolio.common.model.ContractPortfolioRelation;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.integration.support.json.JsonObjectMapper;

@Configuration
public class IntegrationConfig {

	@Autowired
	private Environment env;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Bean
	JsonObjectMapper<?, ?> mapper() {
		return new Jackson2JsonObjectMapper();
	}

	@Bean
	Queue portfolioInitializationRequest() {
		return new Queue(env.getProperty("queues.portfolio.creation"), false);
	}

	@Bean
	IntegrationFlow flow() {
		String to = env.getProperty("queues.portfolio.creation");
		// @formatter:off
		return IntegrationFlows.from(MessageChannels.publishSubscribe(Channels.PortfolioInitializationRequest))
				.transform(Transformers.toJson(mapper())).handle(Amqp.outboundGateway(amqpTemplate).routingKey(to))
				.transform(Transformers.fromJson(ContractPortfolioRelation.class, mapper()))
				.channel(MessageChannels.direct(Channels.PortfolioInitializationResponse)).get();
		// @formatter:on
	}
}
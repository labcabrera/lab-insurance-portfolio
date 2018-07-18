package org.lab.insurance.portfolio.api.controller;

import org.lab.insurance.portfolio.api.IntegrationConstants.Channels;
import org.lab.insurance.portfolio.api.model.EntityReference;
import org.lab.insurance.portfolio.common.model.ContractPortfolioRelation;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface ContractCreationGateway {

	@Gateway(requestChannel = Channels.PortfolioInitializationRequest,
		replyChannel = Channels.PortfolioInitializationResponse)
	ContractPortfolioRelation process(EntityReference msg);

}

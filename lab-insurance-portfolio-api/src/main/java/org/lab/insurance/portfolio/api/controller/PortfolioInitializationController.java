package org.lab.insurance.portfolio.api.controller;

import org.lab.insurance.portfolio.api.model.EntityReference;
import org.lab.insurance.portfolio.common.model.ContractPortfolioRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "init")
public class PortfolioInitializationController {

	@Autowired
	private ContractCreationGateway gateway;

	@RequestMapping(value = "/{contractId}", method = RequestMethod.POST)
	public ContractPortfolioRelation initialize(@PathVariable(value = "contractId") String contractId) {
		return gateway.process(new EntityReference(contractId));
	}

}

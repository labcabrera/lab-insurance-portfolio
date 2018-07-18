package org.lab.insurance.portfolio.core.processor;

import java.util.ArrayList;
import java.util.List;

import org.lab.insurance.portfolio.common.model.ContractPortfolioRelation;
import org.lab.insurance.portfolio.common.model.Portfolio;
import org.lab.insurance.portfolio.common.model.PortfolioOwner;
import org.lab.insurance.portfolio.common.model.PortfolioType;
import org.lab.insurance.portfolio.common.repository.ContractPortfolioRelationRepository;
import org.lab.insurance.portfolio.common.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PortfolioInitializacionProcessor {

	@Autowired
	private PortfolioRepository portfolioRepo;

	@Autowired
	private ContractPortfolioRelationRepository repo;

	public ContractPortfolioRelation initialize(PortfolioOwner owner) {
		String ownerId = owner.getId();
		log.info("Intializing owner {} portfolios", ownerId);

		List<Portfolio> portfolios = new ArrayList<>();
		portfolios.add(Portfolio.builder().type(PortfolioType.PASSIVE).name(ownerId + "/passive").build());
		portfolios.add(Portfolio.builder().type(PortfolioType.ACTIVE).name(ownerId + "/active").build());
		portfolios.add(Portfolio.builder().type(PortfolioType.FEES).name(ownerId + "/fees").build());
		portfolios.add(Portfolio.builder().type(PortfolioType.FISCALITY).name(ownerId + "/fiscality").build());

		portfolioRepo.saveAll(portfolios);

		ContractPortfolioRelation entity = new ContractPortfolioRelation();
		entity.setOwner(owner);
		entity.setPortfolios(new ArrayList<>());
		entity.getPortfolios().addAll(portfolios);

		repo.save(entity);
		return entity;
	}
}

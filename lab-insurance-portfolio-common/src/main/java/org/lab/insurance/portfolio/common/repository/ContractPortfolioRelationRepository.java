package org.lab.insurance.portfolio.common.repository;

import org.lab.insurance.portfolio.common.model.ContractPortfolioRelation;
import org.lab.insurance.portfolio.common.model.PortfolioOwner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractPortfolioRelationRepository extends MongoRepository<ContractPortfolioRelation, String> {

	ContractPortfolioRelation findByOwner(PortfolioOwner contract);

}

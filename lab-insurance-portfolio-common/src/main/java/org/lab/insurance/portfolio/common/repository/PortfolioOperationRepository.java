package org.lab.insurance.portfolio.common.repository;

import java.io.Serializable;

import org.lab.insurance.portfolio.common.model.PortfolioOperation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PortfolioOperationRepository extends MongoRepository<PortfolioOperation, Serializable> {

}

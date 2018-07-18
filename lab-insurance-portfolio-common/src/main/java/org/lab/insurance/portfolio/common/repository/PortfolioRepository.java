package org.lab.insurance.portfolio.common.repository;

import org.lab.insurance.portfolio.common.model.Portfolio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PortfolioRepository extends MongoRepository<Portfolio, String> {

}

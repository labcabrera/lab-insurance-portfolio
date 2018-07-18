package org.lab.insurance.portfolio.common.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class ContractPortfolioRelation {

	@Id
	private String id;

	@DBRef
	private PortfolioOwner owner;

	@DBRef
	private List<Portfolio> portfolios;

}

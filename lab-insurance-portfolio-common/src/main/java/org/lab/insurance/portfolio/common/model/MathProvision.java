package org.lab.insurance.portfolio.common.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class MathProvision {

	@Id
	private String id;
	private PortfolioMathProvision portfolioMathProvision;
	private Investment investment;
	private BigDecimal units;
	private BigDecimal amount;
	private BigDecimal cost;

}

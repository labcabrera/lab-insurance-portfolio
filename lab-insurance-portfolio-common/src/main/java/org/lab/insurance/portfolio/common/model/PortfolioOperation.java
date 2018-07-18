package org.lab.insurance.portfolio.common.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class PortfolioOperation {

	@Id
	private String id;

	@DBRef
	private Investment source;

	@DBRef
	private Investment target;

	@DBRef
	private Asset asset;

	@DBRef
	private MarketOrder marketOrder;

	private Date valueDate;
	private BigDecimal units;
	private BigDecimal amount;
	private String description;

}

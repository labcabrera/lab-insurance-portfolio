package org.lab.insurance.portfolio.common.model;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDistribution {

	@DBRef
	private Asset asset;

	private BigDecimal amount;

	private BigDecimal percent;

}

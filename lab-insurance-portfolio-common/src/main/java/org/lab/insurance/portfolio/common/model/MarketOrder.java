package org.lab.insurance.portfolio.common.model;

import java.math.BigDecimal;

import org.lab.insurance.portfolio.common.common.HasState;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketOrder implements HasState {

	public enum MarketOrderSource {
		UNITS, AMOUNT
	}

	public enum MarketOrderType {
		BUY, SELL
	}

	@Id
	private String id;

	@DBRef
	private Asset asset;

	private MarketOrderType type;
	private MarketOrderSource source;

	private State currentState;
	private OrderDates dates;

	private BigDecimal units;
	private BigDecimal grossAmount;
	private BigDecimal netAmount;
	private BigDecimal nav;

	public enum States {
		INITIAL, PROCESSED, VALUED, ACCOUNTED;
	}
}

package org.lab.insurance.portfolio.common.model;

import java.math.BigDecimal;
import java.util.List;

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

/**
 * Representa un movimiento u operacion de entrada/salida de fondos en un contrato.
 */
@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = { "id", "type" })
public class Order implements HasState {

	public enum States {
		INITIAL, TO_PROCESS, PROCESSING, PROCESSED, VALUING, VALUED, ACCOUNTING, ACCOUNTED;
	};

	public enum OrderType {
		INITIAL_PAYMENT, ADDITIONAL_PAYMENT, REGULAR_PAYMENT, SWITCH, STOP_LOSS, PROGRESS_INVESTMENT, LOCK_IN, PARTIAL_SURRENDER, TOTAL_SURRENDER, REGULAR_SURRENDER, FEES
	};

	@Id
	private String id;

	private OrderType type;

	@DBRef
	private OrderOwner contract;

	private State currentState;
	private OrderDates dates;
	private OrderProcessInfo processInfo;

	private List<OrderDistribution> sellDistribution;
	private List<OrderDistribution> buyDistribution;
	private List<MarketOrder> marketOrders;

	BigDecimal grossAmount;
	BigDecimal netAmount;

	public Order(String id) {
		this.id = id;
	}

}

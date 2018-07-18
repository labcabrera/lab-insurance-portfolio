package org.lab.insurance.portfolio.common.model;

import lombok.Data;

@Data
public class OrderProcessInfo {

	public enum OrderBuyStrategy {

		/**
		 * Por porcentaje de cada {@link OrderDistribution}
		 */
		BY_PERCENT,

		/**
		 * Proporcional a la posicion matematica.
		 */
		PROPORTIONAL_TO_MP;
	};

	public enum OrderSellStrategy {

		/**
		 * Se vende por importe del order. Cada OrderDistribution tiene su importe.
		 */
		SELL_BY_AMOUNT,

		/**
		 * Se vende por las unidades del OrderDistribution.units.
		 */
		SELL_BY_UNITS,

		/**
		 * Se vende a partir de un porcentaje de UCs de la cartera.
		 */
		SELL_BY_MATH_PROVISION_PERCENT,

		/**
		 * Rescate total.
		 */
		SELL_ALL;

	};

	private OrderSellStrategy sellStrategy;
	private OrderBuyStrategy buyStrategy;
	private Portfolio portfolioPassive;
	private Portfolio portfolioActive;

}

package org.lab.insurance.portfolio.common.model;

import java.util.List;

import org.springframework.data.annotation.Id;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Portfolio {

	/**
	 * Representa cada uno de los tipos de carteras del sistema:
	 * <ul>
	 * <li><b>PASIVO</b>: contabilidad interna de las polizas.</li>
	 * <li><b>ACTIVO</b>: contabilidad externa de las polizas utilizado en los ajustes con los brokers.</li>
	 * <li><b>BANK</b>: cartera para llevar la contabilidad del broker.</li>
	 * <li><b>VOID</b>: entradas y salidas del sistema (cheques por ejemplo).</li>
	 * </ul>
	 */
	public enum PortfolioType {

		ACTIVE, PASSIVE, BANK, VOID, FEES, FISCALITY

	}

	@Id
	private String id;

	private String name;

	private PortfolioType type;

	private List<Investment> investments;

}

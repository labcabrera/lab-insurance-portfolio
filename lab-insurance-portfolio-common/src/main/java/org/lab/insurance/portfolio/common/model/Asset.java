package org.lab.insurance.portfolio.common.model;

import java.util.Currency;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Asset {

	@Id
	private String id;

	private String isin;

	private String name;

	private String shortName;

	private AssetType type;
	private Integer decimals;
	private Date fromDate;
	private Date toDate;

	private Currency currency;

	public Asset(String isin) {
		this.isin = isin;
	}
}

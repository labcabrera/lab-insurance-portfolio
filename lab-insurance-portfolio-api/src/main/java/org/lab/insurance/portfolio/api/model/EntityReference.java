package org.lab.insurance.portfolio.api.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//TODO remove
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityReference {

	private String contractId;

	public String getId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

}

package org.lab.insurance.portfolio.common.model;

import java.util.Date;
import java.util.List;

import org.lab.insurance.portfolio.common.common.HasState;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
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
public class Investment implements HasState {

	@Id
	private String id;

	@DBRef
	private Asset asset;

	private State currentState;
	private Date startDate;
	private Date endDate;

	@DBRef
	@JsonIgnore
	private List<PortfolioOperation> inputOperations;

	@DBRef
	@JsonIgnore
	private List<PortfolioOperation> outputOperations;

}

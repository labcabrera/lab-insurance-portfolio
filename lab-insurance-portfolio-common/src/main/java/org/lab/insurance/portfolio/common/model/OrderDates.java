package org.lab.insurance.portfolio.common.model;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDates {

	private Date effective;
	private Date valueDate;
	private Date valued;
	private Date processed;
	private Date accounted;

}

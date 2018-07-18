package org.lab.insurance.portfolio.common.exception;

@SuppressWarnings("serial")
public class PortfolioException extends RuntimeException {

	public PortfolioException(String message, Throwable cause) {
		super(message, cause);
	}

	public PortfolioException(String message) {
		super(message);
	}

	public PortfolioException(Throwable cause) {
		super(cause);
	}

}

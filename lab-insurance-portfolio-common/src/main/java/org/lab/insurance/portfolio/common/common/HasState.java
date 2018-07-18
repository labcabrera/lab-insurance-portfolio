package org.lab.insurance.portfolio.common.common;

import org.lab.insurance.portfolio.common.model.State;

public interface HasState {

	State getCurrentState();

	void setCurrentState(State state);

}

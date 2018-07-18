package org.lab.insurance.portfolio.core.integration;

import org.lab.insurance.portfolio.common.common.HasState;
import org.lab.insurance.portfolio.core.service.StateMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StateMachineProcesor<T extends HasState> {

	@Autowired
	private StateMachineService stateMachineService;

	public T process(T entity, String newState, boolean persist) {
		log.info("Processing state transition: {} -> {} ()", entity, newState, persist);
		stateMachineService.createTransition(entity, newState, persist);
		return entity;
	}

}

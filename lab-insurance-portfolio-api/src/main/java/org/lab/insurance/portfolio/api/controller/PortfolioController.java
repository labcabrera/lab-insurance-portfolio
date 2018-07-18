package org.lab.insurance.portfolio.api.controller;

import org.lab.insurance.portfolio.common.model.Portfolio;
import org.lab.insurance.portfolio.common.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/portfolios")
public class PortfolioController {

	@Autowired
	private PortfolioRepository repository;

	@GetMapping
	public Page<Portfolio> search( //@formatter:off
			@RequestParam(name = "p", defaultValue = "0") Integer page,
			@RequestParam(name = "s", defaultValue = "10") Integer size) { //@formatter:on
		Example<Portfolio> example = Example.of(new Portfolio());
		// TODO filter predicates
		return repository.findAll(example, PageRequest.of(page, size));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Portfolio> searchById(@PathVariable(value = "id") String id) {
		return repository.findById(id).map(x -> new ResponseEntity<>(x, HttpStatus.OK))
			.orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@PostMapping
	public Portfolio insert(@RequestBody Portfolio entity) {
		return repository.insert(entity);
	}

	@PatchMapping
	public Portfolio update(@RequestBody Portfolio entity) {
		return repository.save(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		repository.deleteById(id);
	}

}

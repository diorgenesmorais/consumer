package com.dms.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.consumer.model.Address;
import com.dms.consumer.repository.CepRepository;

import io.swagger.annotations.Api;

@Api(tags = "CEP")
@RequestMapping("/cep")
@RestController
public class CepController {

	@Autowired
	private CepRepository cepRepository;

	@GetMapping("/{cep}")
	public ResponseEntity<Address> getCep(@PathVariable("cep") String cep) {
		Address address = cepRepository.findForCep(cep);

		return address.isValid() ? ResponseEntity.ok(address) : ResponseEntity.notFound().build();
	}
}

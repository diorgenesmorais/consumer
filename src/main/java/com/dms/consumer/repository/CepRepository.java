package com.dms.consumer.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dms.consumer.model.Address;

@FeignClient(url = "https://viacep.com.br/ws/" , name = "viacep")
public interface CepRepository {

	@GetMapping("{cep}/json")
	Address findForCep(@PathVariable("cep") String cep);
}

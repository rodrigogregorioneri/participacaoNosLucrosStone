package com.rodrigo.neri.stone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.neri.stone.model.Funcionario;
import com.rodrigo.neri.stone.service.FuncionarioService;

@RestController
@RequestMapping("/v1/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario create(@Validated @RequestBody  @Valid Funcionario funcionario) {
		return funcionarioService.create(funcionario);
	}

}

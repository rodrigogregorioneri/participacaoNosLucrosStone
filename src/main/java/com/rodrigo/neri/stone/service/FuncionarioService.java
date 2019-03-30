package com.rodrigo.neri.stone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.neri.stone.model.Funcionario;
import com.rodrigo.neri.stone.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	
	@Autowired
	private FuncionarioRepository repository;
	
	public Funcionario create(Funcionario funcionario) {
		return repository.save(funcionario);
	}
	
}

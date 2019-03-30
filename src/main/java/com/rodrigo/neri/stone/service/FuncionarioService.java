package com.rodrigo.neri.stone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rodrigo.neri.stone.model.Funcionario;
import com.rodrigo.neri.stone.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	
	@Autowired
	private FuncionarioRepository repository;
	
	public Funcionario create(Funcionario funcionario) {
		return repository.save(funcionario);
	}
	
    
    public List<Funcionario> createList(@RequestBody List<Funcionario> funcionario) {
    	 List<Funcionario> result = new ArrayList<>();
    	 funcionario.forEach(f ->{
    		 result.add(repository.save(f));
    	 });
    	 return result;
	}
	
}

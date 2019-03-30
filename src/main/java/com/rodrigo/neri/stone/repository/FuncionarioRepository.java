package com.rodrigo.neri.stone.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rodrigo.neri.stone.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

}

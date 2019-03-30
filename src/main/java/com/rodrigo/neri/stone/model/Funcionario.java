package com.rodrigo.neri.stone.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rodrigo.neri.stone.config.Utils;
import com.rodrigo.neri.stone.controller.dto.response.FuncionarioResponse;

import lombok.Data;

@Data
@Document(collection = "employee")
public class Funcionario {
	
	@Id
	private String id;
	
	private String matricula;

	private String nome;

	private String area;

	private String cargo;

	private Double salarioBruto;

	private LocalDate dataDeAdmissao;
	
	
	public FuncionarioResponse toResponse() {
		FuncionarioResponse newResponse = new FuncionarioResponse();
		newResponse.setId(this.id);
		newResponse.setCargo(this.area);
		newResponse.setMatricula(this.matricula);
		newResponse.setNome(this.nome);
		newResponse.setArea(this.area);
		newResponse.setSalarioBruto(Utils.convertString(this.salarioBruto));
		newResponse.setDataDeAdmissao(this.dataDeAdmissao);
		return newResponse;
	}

}

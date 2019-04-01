package com.rodrigo.neri.stone.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rodrigo.neri.stone.config.Utils;
import com.rodrigo.neri.stone.controller.dto.response.FuncionarioResponse;

import lombok.Data;

@Data
@Document(collection = "employee")
public class Funcionario {
	
	@Id
	@Indexed
	private String id;
	
	@NotNull
	private String matricula;

	@NotNull
	private String nome;

	@NotNull
	private String area;

	@NotNull
	private String cargo;

	@NotNull
	@JsonProperty("salario_bruto")
	private Double salarioBruto;

	@NotNull
	@JsonProperty("data_de_admissao")
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

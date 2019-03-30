package com.rodrigo.neri.stone.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

	private Integer salarioBruto;

	private LocalDateTime dataDeAdmissao;

}

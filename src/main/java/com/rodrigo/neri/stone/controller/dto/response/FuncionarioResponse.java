package com.rodrigo.neri.stone.controller.dto.response;

import java.time.LocalDate;

import com.rodrigo.neri.stone.config.Utils;

import lombok.Data;

@Data
public class FuncionarioResponse {

	private String id;
	
	private String matricula;

	private String nome;

	private String area;

	private String cargo;

	private String salarioBruto;

	private LocalDate dataDeAdmissao;
	
}

package com.rodrigo.neri.stone.controller.dto.response;

import java.util.List;

import com.rodrigo.neri.stone.model.Funcionario;

import lombok.Data;

@Data
public class Bonus {

	private List<Funcionario> participacoes = null;

	private String total_de_funcionarios;

	private String total_distribuido;

	private String total_disponibilizado;
	
	private String saldo_total_disponibilizado;

	
}

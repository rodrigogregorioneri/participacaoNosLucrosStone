package com.rodrigo.neri.stone.controller.dto.request;

import java.text.NumberFormat;
import java.time.LocalDate;

import com.rodrigo.neri.stone.config.Utils;
import com.rodrigo.neri.stone.model.Funcionario;

import lombok.Data;

@Data
public class FuncionarioRequest {

	private String matricula;

	private String nome;

	private String area;

	private String cargo;

	private String salarioBruto;

	private LocalDate dataDeAdmissao;
	
	public Funcionario toFuncionario() {
		Funcionario f = new Funcionario();
		f.setMatricula(this.matricula);
		f.setNome(this.nome);
		f.setArea(this.area);
		f.setCargo(this.cargo);
		f.setSalarioBruto(Utils.convertInteger(this.salarioBruto));
		f.setDataDeAdmissao(this.dataDeAdmissao);
		return f;
	}
	



	
}

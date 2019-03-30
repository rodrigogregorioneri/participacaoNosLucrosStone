package com.rodrigo.neri.stone.controller.dto.request;

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

	private String salario_bruto;

	private LocalDate data_de_admissao;
	
	public Funcionario toFuncionario() {
		Funcionario f = new Funcionario();
		f.setMatricula(this.matricula);
		f.setNome(this.nome);
		f.setArea(this.area);
		f.setCargo(this.cargo);
		f.setSalarioBruto(Utils.convertInteger(this.salario_bruto));
		f.setDataDeAdmissao(this.data_de_admissao);
		return f;
	}
	



	
}

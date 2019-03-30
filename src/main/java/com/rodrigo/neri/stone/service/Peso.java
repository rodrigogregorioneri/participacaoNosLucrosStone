package com.rodrigo.neri.stone.service;

import lombok.Data;

@Data
public class Peso {
	
	private Double pesoTempoAdmissao;

	private Double pesoAreaAtuacao;

	private Double pesoFaixaSalarial;

	public Peso(Double pesoTempoAdmissao, Double pesoAreaAtuacao, Double pesoFaixaSalarial) {
		super();
		this.pesoTempoAdmissao = pesoTempoAdmissao;
		this.pesoAreaAtuacao = pesoAreaAtuacao;
		this.pesoFaixaSalarial = pesoFaixaSalarial;
	}
	
	

}

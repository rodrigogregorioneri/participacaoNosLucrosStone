package com.rodrigo.neri.stone.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.neri.stone.config.Utils;
import com.rodrigo.neri.stone.controller.dto.request.FuncionarioRequest;
import com.rodrigo.neri.stone.controller.dto.response.Bonus;
import com.rodrigo.neri.stone.model.Funcionario;
import com.rodrigo.neri.stone.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	Double totalBonus = 0.0;
	
	@Autowired
	private FuncionarioRepository repository;
	
	public Funcionario create(Funcionario funcionario) {
		return repository.save(funcionario);
	}
	
    
    public void createList(List<FuncionarioRequest> funcionario) {
    	 List<Funcionario> result = new ArrayList<>();
    	 funcionario.forEach(f ->{
    		 result.add(repository.save(f.toFuncionario()));
    	 });
	}
    
    public Bonus getBonus(Double valorMaximo) {
    	List<Funcionario> participacoes = new ArrayList<>();
    	Bonus response = new Bonus();
    	
    	repository.findAll().forEach(f ->{
    		participacoes.add(f);
    		Peso peso = validaPeso(f);
    		Double bonus = bonus(f.getSalarioBruto(), peso.getPesoTempoAdmissao(), peso.getPesoAreaAtuacao(), peso.getPesoFaixaSalarial());
    		totalBonus += (bonus); 
    		
    	});
    	response.setParticipacoes(participacoes);
    	response.setTotal_de_funcionarios(String.valueOf(participacoes.size()));
    	response.setTotal_distribuido(Utils.convertString(totalBonus));
    	response.setTotal_disponibilizado(Utils.convertString(valorMaximo));
    	response.setSaldo_total_disponibilizado(Utils.convertString(((valorMaximo-totalBonus))));
    	totalBonus = 0.0;
    	return response;
    }
    
    
    public Double bonus(Double salarioBruto,Double pesoTempoAdmissao, Double pesoAreaAtuacao, Double pesoFaixaSalarial) {
    	return ((salarioBruto * pesoTempoAdmissao) + (salarioBruto * pesoAreaAtuacao) / pesoFaixaSalarial) * 12 ; 
    }
    
    public Peso validaPeso (Funcionario funcionario) {
    	AreaEnum area = AreaEnum.Default;
    	Double pesoAreaAtuacao =	area.getPeso(funcionario.getArea());
    	Double pesoFaixaSalarial =  getFaixaSalarial(funcionario.getSalarioBruto());
    	Double pesoTempoAdmissao =  getPesoData(funcionario.getDataDeAdmissao()).doubleValue();
    	return new Peso(pesoTempoAdmissao,pesoAreaAtuacao,pesoFaixaSalarial);
    }
    
    
    public Long getPesoData(LocalDate dataAdmissao) {
    	Long diferencaEmAnos =  ChronoUnit.YEARS.between( dataAdmissao, LocalDate.now());
    	if(diferencaEmAnos <= 1) {
    		return 1l;
    	}
    	if(diferencaEmAnos > 1 && diferencaEmAnos<3 ) {
    		return 2l;
    	}
    	if(diferencaEmAnos > 3 && diferencaEmAnos<8) {
    		return 3l;
    	}
    	return 5l;
    }
    
    public Double getFaixaSalarial(Double salarioBruto) {
    	Double salarioMinimo = 954.0;
    	Double qtdSalarios = salarioBruto / salarioMinimo;
    	if(qtdSalarios <= 3) {
    		return 1.0;
    	}
    	if(qtdSalarios > 3 && qtdSalarios < 5) {
    		return 2.0;
    	}
    	if(qtdSalarios > 5 && qtdSalarios < 8) {
    		return 3.0;
    	}
    	return 5.0;
    }
    
    
    
    
	
}

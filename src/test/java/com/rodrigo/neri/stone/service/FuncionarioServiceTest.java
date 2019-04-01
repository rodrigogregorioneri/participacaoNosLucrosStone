package com.rodrigo.neri.stone.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rodrigo.neri.stone.model.Funcionario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FuncionarioServiceTest {

	private FuncionarioService funcionarioService;

	@Before
	public void setUp() throws Exception {
		this.funcionarioService = new FuncionarioService();
	}

	@Test
	public void getPesoDataTest() {
		LocalDate ano1 = LocalDate.of(2018, 3, 31);
		Long peso1 = funcionarioService.getPesoData(ano1);
		assertTrue(peso1 == 1l);
		
		LocalDate ano2 = LocalDate.of(2017, 3, 31);
		Long peso2 = funcionarioService.getPesoData(ano2);
		assertTrue(peso2 == 2l);
		
		LocalDate ano3 = LocalDate.of(2014, 3, 31);
		Long peso3 = funcionarioService.getPesoData(ano3);
		assertTrue(peso3 == 3l);
		
		LocalDate ano4 = LocalDate.of(2000, 3, 31);
		Long peso4 = funcionarioService.getPesoData(ano4);
		assertTrue(peso4 == 5l);
	}

	@Test
	public void getFaixaSalarialTest() {
		double qtdSalarios = funcionarioService.getFaixaSalarial(12696.0);
		assertTrue(qtdSalarios == 5.0);
		
		double qtdSalarios1 = funcionarioService.getFaixaSalarial(5096.0);
		assertTrue(qtdSalarios1 == 3.0);
		
		double qtdSalarios2 = funcionarioService.getFaixaSalarial(3000.0);
		assertTrue(qtdSalarios2 == 2.0);
		
		double qtdSalarios3 = funcionarioService.getFaixaSalarial(2696.0);
		assertTrue(qtdSalarios3 == 1.0);
	}
	
	@Test
	public void validaPesoTest() {
		Peso p = new Peso(3.0,1.0,5.0);
		Funcionario func = new Funcionario();
		func.setArea("Diretoria");
		func.setCargo("Diretor Financeiro");
		func.setDataDeAdmissao(LocalDate.of(2012, 1, 05));
		func.setMatricula("0009968");
		func.setNome("Victor Wilson");
		func.setSalarioBruto(12696.0);
		Peso peso = funcionarioService.validaPeso(func);
		assertEquals(peso, peso);
	}
	
	@Test
	public void bonusTest() {
		
	}



}

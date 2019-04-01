package com.rodrigo.neri.stone.controller;
import static org.hamcrest.Matchers.equalTo;
import static com.jayway.restassured.RestAssured.given;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class FuncionarioControllerTest {
	
	@Value("${api.baseURI}")
	private String baseURI;
	
	private Logger logger = LoggerFactory.getLogger(FuncionarioControllerTest.class);
	
	private ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = baseURI;
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON).build();
	}
	

	@Test
	public void createFuncionario() throws Throwable { // @formatter:off
		JsonNode json = getRequestBody("funcionario.json");
		
		logger.info("json: {}", json);
		
		 given().			
			body(json).			
		when().
	       post("v1/funcionarios").
	    then().
	    	statusCode(201).
		   body("matricula", equalTo("0009968")).
		   body("nome", equalTo("Victor Wilson")).
		   body("area", equalTo("Diretoria")).
		   body("cargo", equalTo("Diretoria")).
		   body("salario_bruto", equalTo("R$ 12.696,20")).
		   body("data_de_admissao", equalTo("2012-01-05"));
		
	}
	
	@Test
	public void createFuncionarioValidation() throws Throwable { // @formatter:off
		JsonNode json = getRequestBody("funcionario-validation.json");
		
		logger.info("json: {}", json);
		
		 given().			
			body(json).			
		when().
	       post("v1/funcionarios").
	    then().
	       statusCode(400).
	       body("message", equalTo("Requisição possui campos inválidos")).
	       body("code", equalTo(400)).
	       body("status", equalTo("Bad Request"));
		
	}
	
	
	
	
//	@Test
//	public void createListFuncionarios() throws Throwable { // @formatter:off
//		JsonNode json = getRequestBody("funcionarios.json");
//		
//		logger.info("json: {}", json);
//		
//		 given().			
//			body(json).			
//		when().
//	       post("v1/funcionarios/createlist").
//	    then().
//	    	statusCode(201);
//		
//	}
	
	private JsonNode getRequestBody(String filename) throws Throwable {
		File src = ResourceUtils.getFile("classpath:json/request/" + filename);
		return objectMapper.readValue(src, JsonNode.class);
	}

}

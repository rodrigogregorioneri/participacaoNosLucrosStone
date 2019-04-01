package com.rodrigo.neri.stone.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.rodrigo.neri.stone.service.FuncionarioServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ FuncionarioControllerTest.class,FuncionarioServiceTest.class  })
public class AllTests {

}

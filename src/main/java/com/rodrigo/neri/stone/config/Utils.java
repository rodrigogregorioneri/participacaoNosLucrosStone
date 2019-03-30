package com.rodrigo.neri.stone.config;

import java.text.NumberFormat;
import java.util.Locale;

public final class Utils {
	
	public static  Double convertInteger(String salarioBruto) {
		salarioBruto = salarioBruto.replace(".", "");
		salarioBruto = salarioBruto.replace(",", ".");
		String[] stringNova = salarioBruto.split(" ");
		return Double.parseDouble(stringNova[1]);
	}
	
	
	public static String convertString(Double salarioBruto) {
		Locale ptBR = new Locale("pt", "BR");
		NumberFormat moedaFormat = 
				  NumberFormat.getCurrencyInstance(ptBR);
		
		return moedaFormat.format(salarioBruto);
	}
	
	public static String stringConvertString(String salarioBruto) {
		Locale ptBR = new Locale("pt", "BR");
		NumberFormat moedaFormat = 
				  NumberFormat.getCurrencyInstance(ptBR);
		
		return moedaFormat.format(salarioBruto);
	}

}

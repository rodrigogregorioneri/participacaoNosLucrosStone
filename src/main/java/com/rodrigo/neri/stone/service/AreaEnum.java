package com.rodrigo.neri.stone.service;

public enum AreaEnum {

	Diretoria("Diretoria",1),
	Contabilidade("Contabilidade",2),
	Financeiro("Financeiro",2),
	Tecnologia("Tecnologia",2),
	ServicosGerais("Serviços Gerais",3),
	RelacionamentoCliente("Relacionamento com o Cliente",5),
	Default("Default",0);
	
	private String nome;
    private double valor;
    
    AreaEnum(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public double getValor(){
        return this.valor;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getPeso(String nome) {
    	for (AreaEnum a : AreaEnum.values()) {
    	     if(a.getNome().equals(nome)) {
    	    	 return a.getValor();
    	     }
    	  }
    	return 0;
    }
	
}

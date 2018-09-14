package br.ce.util;

public interface Hardware {
	
	 public abstract String pegarNumeroDaContaCartao(String numero) throws Exception;
	 public abstract void entregarDinheiro(boolean values) throws Exception; 
	 public abstract void lerEnvelope() throws Exception;
	
}

package br.ce.util;

public class ContaCorrente {

	private Integer id;
	private String numeroDaConta;
	private float saldo;	
	

	public ContaCorrente() {
	
	}
	
	public ContaCorrente(String numeroDaConta) {	
		this.numeroDaConta = numeroDaConta;
	}
	
	public ContaCorrente(String numeroDaConta, float saldo) {	
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;	
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float valor) {
		this.saldo+= valor;
	}
		
}

package br.ce.testes;

import org.junit.Test;

import br.ce.mocks.MockObservadorCaixaEletronico;
import br.ce.mocks.MockObservadorContaCorrente;
import br.ce.util.ContaCorrente;
import br.ce.util.ServicoRemoto;

public class TestCaixaEletronico {
	
	private ContaCorrente conta;
	private MockObservadorCaixaEletronico mock = new MockObservadorCaixaEletronico();	
	
	@Test
	public void testLogar() {
	   String numeroDaConta = "13256-3";	  
	   mock.logar(numeroDaConta);	   		
	}
		
	@Test
	public void testSaqueComSucesso() {
	   ContaCorrente conta = new ContaCorrente("13256-3", 1200.16f);
	   float valorDoSaque = 300.00f;
	   conta.setSaldo(100f);
	   mock.saqueComSucesso(valorDoSaque, conta);	   		
	}
	
	@Test
	public void testSaqueComSaldoInsuficiente() {
	   ContaCorrente conta = new ContaCorrente("13256-3", 1200.16f);
	   float valorDoSaque = 1800.10f;
	   mock.saqueComSaldoInsuficiente(valorDoSaque, conta);	   		
	}
	
	@Test
	public void testDepositar() {
	   ContaCorrente conta = new ContaCorrente("13256-3", 1200.00f);
	   float valorDeposito = 1300.00f;
	   mock.depositar(valorDeposito, conta);	   		
	}	
	
	@Test
	public void testMockAdicionarConta() {		 
		conta = new ContaCorrente("12571-3", 2852.36f);		
		ServicoRemoto mock = new MockObservadorContaCorrente();
		mock.persistirConta(conta);		
	}
	
	@Test
	public void testVerificaConta() {
		String c = "12571-3";
		conta = new ContaCorrente(c);
		ServicoRemoto mock = new MockObservadorContaCorrente();
		mock.persistirConta(conta);
		mock.recuperarConta(c);		
	}

}

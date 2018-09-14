package br.ce.mocks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import br.ce.util.CaixaEletronico;
import br.ce.util.ContaCorrente;
import br.ce.util.ContaCorrenteDAO;
import br.ce.util.HardwareDAO;
import br.ce.util.ServicoRemoto;

public class MockObservadorCaixaEletronico implements ServicoRemoto {
	

	private ContaCorrenteDAO contaDAO = new ContaCorrenteDAO();		
	private CaixaEletronico caixa = new CaixaEletronico();
	private HardwareDAO hard = new HardwareDAO();
	
	public MockObservadorCaixaEletronico(){		
		ContaCorrente conta1 = new ContaCorrente("12385-2", 10640.25f);
		ContaCorrente conta2 = new ContaCorrente("13256-3", 1025.58f);
		ContaCorrente conta3 = new ContaCorrente("14287-4", 650.12f);
		this.persistirConta(conta1);
		this.persistirConta(conta2);
		this.persistirConta(conta3);			
	}		
	
	public String logar(String numeroDaConta) {	   
	   String msg = caixa.logar(numeroDaConta);
	   assertEquals(msg, CaixaEletronico.MSG1);		   
	   return msg;
	}
	
	public String saqueComSucesso(float valorSacar, ContaCorrente conta) {
		try{
			String msg = caixa.sacar(valorSacar, conta);
			boolean testador = caixa.isTestador();
			hard.entregarDinheiro(testador);				
			assertEquals(msg, CaixaEletronico.MSG2);			
			return msg;			
			
		}catch(Exception e){
			System.out.println(HardwareDAO.MSG1_ERRO1_1);
			return null;
		}	
		
	}
	
	public String saqueComSaldoInsuficiente(float valorSacar, ContaCorrente conta) {
		String msg = caixa.sacar(valorSacar, conta);
		assertEquals(msg, CaixaEletronico.MSG2_ERRO2);
		return msg;
	}
	
	public String depositar(float valorDepositado, ContaCorrente conta) {
		String msg = caixa.depositar(valorDepositado, conta);
		assertEquals(msg, CaixaEletronico.MSG3);
		return msg;
	}
	
	@Override
	public void persistirConta(ContaCorrente conta) {
	   assertTrue(contaDAO.adicionarConta(conta));		
	}

	@Override
	public ContaCorrente recuperarConta(String numero) {
		assertEquals(contaDAO.recuperaConta(numero).getNumeroDaConta(), "12571-3"); 		
		return contaDAO.recuperaConta(numero);
	}

}

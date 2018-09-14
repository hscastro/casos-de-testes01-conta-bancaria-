package br.ce.util;

import br.ce.mocks.MockObservadorCaixaEletronico;

public class HardwareDAO implements Hardware {
	
	public static String MSG1_1 = "RETIRE O SEU DINHEIRO!";	
	public static String MSG1_ERRO1_1 = "ERRO [1002F] NÃO FOI POSSÍVEL O SAQUE!"; 
	
	private ContaCorrenteDAO contaDAO = new ContaCorrenteDAO();	
	private CaixaEletronico caixaEle = new CaixaEletronico();
	
	@Override
	public String pegarNumeroDaContaCartao(String numero) throws Exception {		
		return contaDAO.recuperaConta(numero).getNumeroDaConta();
	}

	@Override
	public void entregarDinheiro(boolean values) throws Exception {		
		if(values){
			System.out.println(MSG1_1);	
		}
	}

	@Override
	public void lerEnvelope() throws Exception {
		// TODO Auto-generated method stub		
	}	

}

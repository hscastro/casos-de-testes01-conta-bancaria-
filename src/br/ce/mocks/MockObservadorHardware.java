package br.ce.mocks;

import static org.junit.Assert.assertEquals;
import br.ce.util.Hardware;
import br.ce.util.HardwareDAO;

public class MockObservadorHardware implements Hardware {
	
	private HardwareDAO hardDAO = new HardwareDAO();

	@Override
	public String pegarNumeroDaContaCartao(String numero) throws Exception {
		String numeroDaConta = hardDAO.pegarNumeroDaContaCartao(numero);  
		assertEquals(numeroDaConta, numero);			 	    
		return numeroDaConta;					
	}
	
	@Override
	public void lerEnvelope() throws Exception {
			
	}

	@Override
	public void entregarDinheiro(boolean values) throws Exception {
		hardDAO.entregarDinheiro(true);		
	}

}

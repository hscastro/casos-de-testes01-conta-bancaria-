package br.ce.testes;

import org.junit.Test;

import br.ce.mocks.MockObservadorContaCorrente;
import br.ce.mocks.MockObservadorHardware;
import br.ce.util.ContaCorrente;
import br.ce.util.Hardware;
import br.ce.util.ServicoRemoto;


public class TestHardware {

	@Test
	public void testPegarNumeroDaConta() throws Exception {
		String cc = "12571-3";
		ContaCorrente conta = new ContaCorrente(cc);
		ServicoRemoto moc = new MockObservadorContaCorrente();
		moc.persistirConta(conta);
		Hardware mock = new MockObservadorHardware();	
		mock.pegarNumeroDaContaCartao(cc);
	}
}

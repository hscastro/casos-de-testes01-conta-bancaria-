package br.ce.mocks;

import br.ce.util.ContaCorrente;
import br.ce.util.ContaCorrenteDAO;
import br.ce.util.ServicoRemoto;

public class MockObservadorContaCorrente implements ServicoRemoto {

	private ContaCorrenteDAO contaDAO = new ContaCorrenteDAO();
	
	@Override
	public ContaCorrente recuperarConta(String numero) {		
		return contaDAO.recuperaConta(numero);
	}

	@Override
	public void persistirConta(ContaCorrente conta) {
		contaDAO.adicionarConta(conta);
	}

}

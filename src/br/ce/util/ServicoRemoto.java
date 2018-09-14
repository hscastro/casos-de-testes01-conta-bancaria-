package br.ce.util;

public interface ServicoRemoto {
	
	public abstract ContaCorrente recuperarConta(String numero);
	public abstract void persistirConta(ContaCorrente conta);
}

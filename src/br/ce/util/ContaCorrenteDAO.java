package br.ce.util;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrenteDAO {

	private List<ContaCorrente> lista; 
	
	public ContaCorrenteDAO() {		
		lista = new ArrayList<ContaCorrente>();		
	}

	public boolean adicionarConta(ContaCorrente conta){
		if(conta != null){
			lista.add(conta);
			return true;
		}else{
			return false;
		}	
			
	}
	
	public void removerConta(ContaCorrente conta){
		lista.remove(conta.getId());
	}	
	
	
	public List<ContaCorrente> listarContas() {
		
	   for(int i = 0; i < lista.size(); i++){
		   lista.get(i);		   
	   }
	   
	   return lista;
	}
	
	public ContaCorrente recuperaConta(String numero) {		
	    ContaCorrente conta = new ContaCorrente(numero);
	    
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getNumeroDaConta().equals(numero)){
				conta = lista.get(i);
			}		   		   
	   }
	   
	   return conta;
	}	

	public void adicionaObservador() {
				
	}
}

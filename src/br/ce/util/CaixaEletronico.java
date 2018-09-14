package br.ce.util;

public class CaixaEletronico {
		
	private ContaCorrenteDAO contaDAO;
	public static String MSG1 = "USUÁRIO AUTENTICADO!"; 
	public static String MSG1_ERRO1 = "NÃO FOI POSSÍVEL AUTENTICADO O USUÁRIO!"; 
	public static String MSG2 = "RETIRE O SEU DINHEIRO!"; 
	public static String MSG2_ERRO2 = "SALDO INSUFICIENTE!"; 
	public static String MSG3 = "DEPOSITO RECEBIDO COM SUCESSO!"; 
	public static String MSG3_ERRO3 = "ERRO EFETUAR O DEPOSITO, TENTE NOVAMENTE!"; 
	private static boolean testador = false;
	
	
	public CaixaEletronico() {		
	   contaDAO = new ContaCorrenteDAO();
	}
	
	 public String logar(String numeroDaConta){		 
		 String numeroDaContaDAO = contaDAO.recuperaConta(numeroDaConta)
				 .getNumeroDaConta();
		 
		 if(numeroDaContaDAO == numeroDaConta) {	
			 testador = true;
			 return MSG1;			
		 }else{
			 return MSG1_ERRO1; 
		 }			 
	 } 
	 
	 public String sacar(float valor, ContaCorrente c) {	
		 float saldo = c.getSaldo(); 
		 
		 if(saldo > 0 && valor <= saldo) {
			saldo = c.getSaldo() - valor;	
			testador = true;
			return MSG2;			 
		  }else{
			 return MSG2_ERRO2;
		  }			 		 
	 } 
	 
	 public String depositar(float valorDoDeposito, ContaCorrente c){		 
		 float totalRecebido = 0;		 
		 String numeroDaContaDAO = contaDAO.recuperaConta(c.getNumeroDaConta())
				 .getNumeroDaConta();
		 
		 if(c.getNumeroDaConta() == numeroDaContaDAO) {
			totalRecebido = c.getSaldo()+valorDoDeposito; 
			c.setSaldo(totalRecebido);		
			testador = true;
			return MSG3;			
		 }else{
			return MSG3_ERRO3;
		 }		 		 
	 } 
	 
	 public String consultarSaldo(ContaCorrente c){		 
		 String numeroDaContaDAO = contaDAO.recuperaConta(c.getNumeroDaConta())
				 .getNumeroDaConta();
		 
		 if(numeroDaContaDAO == c.getNumeroDaConta()) {		
			 testador = true;
			 return "R$ "+c.getSaldo();			
		 }else{
			 return MSG1_ERRO1; 
		 }			 
	 }

	public static boolean isTestador() {
		return testador;
	} 
		 	 
}

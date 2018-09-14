package br.ce.testes;

import static org.junit.Assert.*;

import org.junit.Test;
import br.ce.util.ContaCorrente;

public class TestContaCorrente {
		
	@Test
	public void testSaldoDaConta() {	
		ContaCorrente cc = new ContaCorrente("12571-3", 2852.36f);
		assertEquals(cc.getSaldo(), 0, 2852.36f);	
	}
	
	@Test
	public void testAcrescimoNoSaldo() {
		ContaCorrente cc = new ContaCorrente("12120-2", 8652.09f);
		cc.setSaldo(100);			
		assertEquals(cc.getSaldo(), 0, 8752.36f);		
	}
	
}

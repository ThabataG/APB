package testes;

import static org.junit.Assert.*;
import junit.framework.Assert;

import model.Servico;

import org.junit.Test;

import exception.ServicoException;

public class ServicoTeste {

	Servico servico = new Servico();
	@Test (expected = NullPointerException.class)
	public void testeSetNomeNaoNulo() throws ServicoException {
		servico.setNome(null);
		Assert.fail("Deve lan�ar exce��o");
	}
	
	@Test (expected = ServicoException.class)
	public void PrecoForaDeFormato() throws ServicoException {
		servico.setPreco("as");
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test (expected = NullPointerException.class)
	public void testePrecoNaoNulo() throws ServicoException {
		servico.setPreco(null);
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test (expected = ServicoException.class)
	public void TestePrecoEmBranco() throws ServicoException {
		servico.setPreco("");
		Assert.fail("Deve lan�ar exce��o");
	}
	
	@Test
	public void TestePrecoRecebeFormatoCorreto () {
		try {
			servico.setPreco("123,45");
		} catch (ServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("N�o deve lan�ar exce��o");
		}
		assertEquals("123,45", servico.getPreco());
		
		
	}
}

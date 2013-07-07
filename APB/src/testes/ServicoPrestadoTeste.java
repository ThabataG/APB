package testes;

import static org.junit.Assert.*;
import junit.framework.Assert;

import model.ServicoPrestado;

import org.junit.Test;

import exception.ServicoException;

public class ServicoPrestadoTeste {

	ServicoPrestado servico = new ServicoPrestado();
	@Test (expected = NullPointerException.class)
	public void testeSetNomeNaoNulo() throws ServicoException {
		servico.setNomeServico(null);
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
			e.printStackTrace();
			Assert.fail("N�o deve lan�ar exce��o");
		}
		assertEquals("123,45", servico.getPreco());
		
		
	}
}

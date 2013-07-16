package testes;

import static org.junit.Assert.*;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;

import model.ServicoPrestado;

import org.junit.Test;

import exception.ServicoException;

public class ServicoPrestadoTeste {

	ServicoPrestado servico = new ServicoPrestado();
	
	@Test
	public void testeDeConstrutor(){
		ServicoPrestado servico1 = new ServicoPrestado("Corte", "15,00","Claudio");
		assertEquals("Corte", servico1.getNomeServico());
		assertEquals("15,00", servico1.getPreco());
		assertEquals("Claudio", servico1.getNomeBarbeiro());
	}
	@Test (expected = NullPointerException.class)
	public void testeSetNomeNaoNulo() throws ServicoException {
		servico.setNomeServico(null);
		Assert.fail("Deve lan�ar exce��o");
	}
	
	@Test (expected = ServicoException.class)
	public void testeSetNomeBranco() throws ServicoException {
		servico.setNomeServico("");
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test (expected = ServicoException.class)
	public void testeSetNomeForaDeFormato() throws ServicoException {
		servico.setNomeServico("123");
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test
	public void testeSetNomeValido() {
		try {
			servico.setNomeServico("Corte");
		} catch (ServicoException e) {
			e.printStackTrace();
			Assert.fail("N�o deve lan�ar exce��o");
		}
		assertEquals("Corte", servico.getNomeServico());
	}
	
	@Test (expected = ServicoException.class)
	public void precoForaDeFormato() throws ServicoException {
		servico.setPreco("as");
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test (expected = NullPointerException.class)
	public void testePrecoNaoNulo() throws ServicoException {
		servico.setPreco(null);
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test (expected = ServicoException.class)
	public void testePrecoEmBranco() throws ServicoException {
		servico.setPreco("");
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test
	public void testePrecoValidoo() {
		try {
			servico.setPreco("123,45");
		} catch (ServicoException e) {
			Assert.fail("N�o deve lan�ar exce��o");
		}
		assertEquals("123,45", servico.getPreco());
	}
	
	@Test (expected = NullPointerException.class)
	public void testeNomeBarbeiroNulo() throws ServicoException {
		servico.setNomeBarbeiro(null);
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test (expected = ServicoException.class)
	public void testeNomeBarbeiroEmBranco() throws ServicoException {
		servico.setNomeBarbeiro("");
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test (expected = ServicoException.class)
	public void testeNomeBarbeiroForaDeFormato() throws ServicoException {
		servico.setNomeBarbeiro("123");
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test
	public void testeNomeBarbeiroValido() {
		try {
			servico.setNomeBarbeiro("Jo�o");
		} catch (ServicoException e) {
			Assert.fail("N�o deve lan�ar exce��o");
		}
		assertEquals("Jo�o", servico.getNomeBarbeiro());
	}
	
	@Test (expected = AssertionFailedError.class)
	public void testeDataNulo() throws ServicoException {
		servico.setData(null);
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test (expected = AssertionFailedError.class)
	public void testeDataEmBranco() throws ServicoException {
		servico.setData("");
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
	@Test (expected = AssertionFailedError.class)
	public void testeDataForaDeFormato() throws ServicoException {
		servico.setData("abc");
		Assert.fail("Deve lan�ar uma exce��o");
	}
	
}

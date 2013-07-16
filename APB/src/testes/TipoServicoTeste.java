package testes;

import static org.junit.Assert.*;
import junit.framework.Assert;
import model.TipoServico;

import org.junit.Before;
import org.junit.Test;

import exception.ServicoException;

public class TipoServicoTeste {
	
	TipoServico  servico =  new TipoServico();
	@Before
	public void setUp(){
		try {
			servico.setNomeTipoServico("Corte");
			servico.setPreco("14,50");
		} catch (ServicoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getterDeNomeDeveRetornarValorPassado(){
		assertEquals("Corte", servico.getNomeTipoServico());
	}
	
	@Test
	public void getterDePrecoDeveRetornarValorPassado(){
		assertEquals("14,50", servico.getPreco());
	}

	@Test(expected =  NullPointerException.class)
	public void setterDePrecoN�oPodeSerNulo() throws ServicoException{
		servico.setPreco(null);
		Assert.fail("Deve lan�ar exce��o");
	}

	@Test(expected = NullPointerException.class)
	public void setterDeNomeN�oPodeSerNulo() throws ServicoException{
		servico.setNomeTipoServico(null);
		Assert.fail("Deve lan�ar exce��o");
	}
	
	@Test(expected = ServicoException.class)
	public void setterDeNomeN�oPodeSerInvalido() throws ServicoException{
		servico.setNomeTipoServico("Cor#t�");
		Assert.fail("Deve lan�ar exce��o");
	}
	@Test(expected = IllegalArgumentException.class)
	public void setterDePrecoN�oPodeSerInvalido() throws ServicoException{
		servico.setPreco("14.50%");
		Assert.fail("Deve lan�ar exce��o");
	}

	@Test(expected =  ServicoException.class)
	public void setterDePrecoServicoNaoPodeSerEmBranco() throws ServicoException{
		servico.setPreco("");
		Assert.fail("Deve lan�ar exce��o");
	}

	@Test(expected =  ServicoException.class)
	public void setterDeNomeServicoNaoPodeSerEmBranco() throws ServicoException{
		servico.setNomeTipoServico("");
		Assert.fail("Deve lan�ar exce��o");
	}


}

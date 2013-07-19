package testes;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Barbeiro;

import org.junit.Before;
import org.junit.Test;

import control.BarbeiroController;
import exception.BarbeiroException;

public class BarbeiroControllerTeste {

	Barbeiro barbeiro = new Barbeiro();

	@Before
	public void setUp() {
		try {
			barbeiro.setNome("Alessandro");
			barbeiro.setRg("418757896");
			barbeiro.setTelefone("3389-9085");
			barbeiro.setCpf("02919594150");
			barbeiro.setCadeira("5");
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (BarbeiroException e) {
			e.printStackTrace();
		}
	}
	
	BarbeiroController barbeiroController = BarbeiroController.getInstance();

	@Test
	public void getInstanceDeBarbeiroControlerDeveRetonarInstanciaCorrente() {
		assertEquals(BarbeiroController.getInstance(), barbeiroController);
	}

	@Test
	public void inserirDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		try {
			assertTrue(barbeiroController.inserir(barbeiro));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void excluirDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		try {
			assertTrue(barbeiroController.excluir(barbeiro));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void alterarDeBarbeiroControllerDeveEnviarUmBarbeiro() {
		try {
			assertTrue(barbeiroController.alterar(barbeiro));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void inserirBarbeiroN�oPodePassarBarbeiroNullo() {
		try {
			assertFalse(barbeiroController.inserir(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void excluirBarbeiroN�oPodePassarBarbeiroNullo() {
		try {
			assertFalse(barbeiroController.excluir(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void alterarBarbeiroN�oPodePassarBarbeiroNullo() {
		try {
			assertFalse(barbeiroController.alterar(null));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void procurarPorBarbeiroControllerDeveMostrarUmBarbeiro() throws SQLException {
		ResultSet rs = barbeiroController.pesquisar();
		while (rs.next());
	}
	
	@Test
	public void mostrarBarbeirosDeBarbeiroControllerDeveMostrarUmBarbeiro() throws SQLException {
		ResultSet rs = barbeiroController.mostrarBarbeirosCadastrados(barbeiro);
		while(rs.next());
	}
}

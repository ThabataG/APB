package testes;

import static org.junit.Assert.*;
import exception.BarbeiroException;
import model.Barbeiro;

import org.junit.Test;

public class BarbeiroTeste {

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirNomeNuloPassandoPeloSetter() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setNome(null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirCPFNuloPassandoPeloSetter() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setCpf(null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirRGNuloPassandoPeloSetter() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setRg(null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirTelefoneNuloPassandoPeloSetter() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setTelefone(null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = NullPointerException.class)
	public void barbeiroNaoPodePossuirCadeiraNuloPassandoPeloSetter() {
		Barbeiro barbeiro = new Barbeiro();
		try {
			barbeiro.setCadeira(null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComNomeNulo() {
		try {
			new Barbeiro(null, "493.751.185-84", "2258256", "3389-9085", "5");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComCpfNulo() {
		try {
			new Barbeiro("Alessandro", null, "2258256", "3389-9085", "5");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComRgNulo() {
		try {
			new Barbeiro("Alessandro", "493.751.185-84", null, "3389-9085", "5");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComTelefoneNulo() {
		try {
			new Barbeiro("Alessandro", "493.751.185-84", "2258256", null, "5");
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void contrutorDeBarbeiroNaoPodePassarComCadeiraNulo() {
		try {
			new Barbeiro("Alessandro", "493.751.185-84", "2258256",
					"3389-9085", null);
		} catch (BarbeiroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
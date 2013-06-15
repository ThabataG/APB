package model;

import exception.ServicoException;

public class Servico {

	private String nome;
	private String nomeBarbeiro;
	private String preco;
	private String data;

	private final String NOME_INVALIDO = "Nome do Servi�o Inv�lido";
	private final String NOME_BRANCO = "Nome do Servi�o em Branco";
	private final String BARBEIRO_INVALIDO = "Nome do Barbeiro em Branco";
	private final String BARBEIRO_BRANCO = "Insira um Barbeiro respons�vel pelo servi�o";
	private final String PRECO_INVALIDO = "Pre�o Inv�lido";
	private final String PRECO_BRANCO = "Pre�o em Branco";
	private final String DATA_INVALIDA = "Data Inv�lida";
	private final String DATA_BRANCO = "Data em Branco";

	public Servico() {

	}

	public Servico(String nome, String preco, String nomeBarbeiro, String data) {
		this.nome = nome;
		this.preco = preco;
		this.data = data;
		this.nomeBarbeiro = nomeBarbeiro;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeBarbeiro() {
		return nomeBarbeiro;
	}

	public String getPreco() {
		return preco;
	}

	public String getData() {
		return data;
	}

	public void setNome(String nome) throws ServicoException {
		try {
			if ("".equals(nome))
				throw new ServicoException(NOME_BRANCO);
			else if (nome.matches("[a-zA-Z\\s]+"))
				this.nome = nome;
			else
				throw new ServicoException(NOME_INVALIDO);
		} catch (StringIndexOutOfBoundsException e) {
			throw new ServicoException(NOME_INVALIDO);
		}
	}

	public void setNomeBarbeiro(String nomeBarbeiro) throws ServicoException {
		try {
			if ("".equals(nomeBarbeiro))
				throw new ServicoException(BARBEIRO_BRANCO);
			else if (nomeBarbeiro.matches("[a-zA-Z\\s]+"))
				this.nomeBarbeiro = nomeBarbeiro;
			else
				throw new ServicoException(BARBEIRO_INVALIDO);
		} catch (StringIndexOutOfBoundsException e) {
			throw new ServicoException(BARBEIRO_INVALIDO);
		}
	}

	public void setPreco(String preco) throws ServicoException {
		try {
			if ("".equals(preco))
				throw new ServicoException(PRECO_BRANCO);
			else if (preco.matches("[\\d]{1,3},[\\d]{1,2}"))
				this.preco = preco;
			else
				throw new ServicoException(PRECO_INVALIDO);
		} catch (IllegalArgumentException e) {
			throw new ServicoException(PRECO_INVALIDO);
		}
	}

	public void setData(String data) throws ServicoException {
		try {
			if ("".equals(data))
				throw new ServicoException(DATA_BRANCO);
			else if (data.matches("[\\d]{2}/[\\d]{2}/[\\d]{2,4}"))
				this.data = data;
			else
				throw new ServicoException(DATA_INVALIDA);
		} catch (StringIndexOutOfBoundsException e) {
			throw new ServicoException(DATA_INVALIDA);
		} catch (NumberFormatException e) {
			throw new ServicoException(DATA_INVALIDA);
		}

	}

}

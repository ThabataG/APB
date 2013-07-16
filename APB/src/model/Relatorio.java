package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Relatorio {

	private String dataInicial;
	private String dataFinal;
	private String barbeiro;
	private String tipoServico;
	private SimpleDateFormat formatoDaData;
	private Date data;

	public Relatorio(String dataInicial, String dataFinal, String barbeiro,
			String tipoServico) {
		super();
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.barbeiro = barbeiro;
		this.tipoServico = tipoServico;
	}

	public Relatorio() {
	}

	public String getDataInicial() {
		return dataInicial;
	}


	public void setDataInicial(String dataInicial) {

	
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {

		this.dataFinal = dataFinal;
	}

	public String getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(String barbeiro) {
		this.barbeiro = barbeiro;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

}

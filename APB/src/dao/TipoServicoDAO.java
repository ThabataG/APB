package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import control.TipoServicoController;
import view.AlterarTipoServico;

import model.Barbeiro;
import model.TipoServico;



public class TipoServicoDAO {

	private static TipoServicoDAO instance;

	private TipoServicoDAO() {
	}

	public static TipoServicoDAO getInstance() {
		if (instance == null)
			instance = new TipoServicoDAO();
		return instance;
	}

	public boolean incluir(TipoServico tipoServico) throws SQLException {
		if (tipoServico == null) {
			return false;
		} else {
			this.updateQuery("INSERT INTO "
					+ "tipoServico (nome, preco) VALUES ("
					+ "\"" + tipoServico.getNomeTipoServico() + "\", " + "\""
					+ tipoServico.getPreco() + "\"); ");

			return true;
		}
	}

	public boolean alterar(TipoServico tipoServico_alterado, TipoServico tipoServico)
			throws SQLException {
		if (tipoServico_alterado == null || tipoServico == null) {
			return false;
		} else {
			this.updateQuery("UPDATE tipoServico SET nome = '"
					+ tipoServico_alterado.getNomeTipoServico() + "', " + "preco = '"
					+ tipoServico_alterado.getPreco()  + "' WHERE"
					+ " nome = '" + AlterarTipoServico.getNomeTipoServicoAntigo() + "';");

			return true;
		}
	}

	public boolean excluir(TipoServico tipoServico) throws SQLException {
		if (tipoServico == null) {
			return false;
		} else {
			this.updateQuery("DELETE FROM tipoServico WHERE "
					+ "tipoServico.nome = \"" + tipoServico.getNomeTipoServico() + "\";");
			return true;

		}
	}

	public void updateQuery(String message) throws SQLException {
		Connection connection = FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement(message);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

}

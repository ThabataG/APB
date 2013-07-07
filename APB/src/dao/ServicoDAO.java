package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ServicoPrestado;

public class ServicoDAO {
	
	private static ServicoDAO instance;
	
	private ServicoDAO(){
	}
	public static ServicoDAO getInstance(){
		if(instance == null)
			instance = new ServicoDAO();
		return instance;
	
	}
	
	public boolean incluir(ServicoPrestado servico) throws SQLException{
		if(servico != null){
		this.updateQuery("INSERT INTO " +
					"servico (nome, preco, barbeiro, data) VALUES (" +
					"\"" + servico.getNome() + "\", " +
					"\"" + servico.getPreco() + "\", " +
					"\"" + servico.getNomeBarbeiro()+ "\", " +
					"\"" + servico.getData() + "\"); "
				);
		return true;
		}else{
			return false;
		}
	
	}
	
	public void alterar(ServicoPrestado servico_alterado, ServicoPrestado servico) throws SQLException {			
		this.updateQuery("UPDATE servico SET " +
				"nome = \"" + servico_alterado.getNome() + "\", " +
				"preco = \"" + servico_alterado.getPreco() + "\", " +
				"barbeiro = \"" + servico_alterado.getNomeBarbeiro() + "\", " +
				"data = \"" + servico_alterado.getData() + "\", " +
				" WHERE " +
				"servico.preco = \"" + servico.getPreco() + "\";"
				);
	}

	public void excluir(ServicoPrestado servico) throws SQLException {
		this.updateQuery("DELETE FROM servico WHERE " +
				"servico.nome = \"" + servico.getNome() + "\";"
				);
	}

	
	private void updateQuery(String message) throws SQLException{
		Connection connection =  FactoryConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(message);
		preparedStatement.executeUpdate();		
		preparedStatement.close();
		connection.close();
	}
	
}



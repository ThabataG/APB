package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AgendaDAO;
import model.Agenda;


public class AgendaController {
	
	private static AgendaController instance;
	
	private AgendaController() {}
	
	public boolean incluir(Agenda agenda) throws SQLException {
		if(agenda == null )
			return false;
		
		AgendaDAO.getInstance().incluir(agenda);
		return true;
	}
	
	public boolean alterar(Agenda agenda) throws SQLException {
		if(agenda == null )
			return false;
		
		Agenda agenda_alterado = agenda;
		AgendaDAO.getInstance().alterar(agenda_alterado, agenda);
		return true;		
	}

	public  boolean excluir(Agenda agenda) throws SQLException {
		if (agenda == null)
			return false;
		
		AgendaDAO.getInstance().excluir(agenda);
		return true;
	}
	
	public static AgendaController getInstance() {
		if(instance == null)
			instance = new AgendaController();
		return instance;
	}
	
	public ResultSet mostrarContatosCadastrados(Agenda contato) throws SQLException {
		return AgendaDAO.getInstance().mostrarContatosCadastrados(contato);
	}

}

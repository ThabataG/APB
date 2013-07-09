package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.ServicoPrestadoController;
import exception.ServicoException;
import model.ServicoPrestado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import dao.FactoryConnection;

@SuppressWarnings("serial")
public class NovoServicoPrestado extends JFrame {

	private JPanel contentPane;
	private JTextField textValor;
	private JTextField textData;
	private Connection connection;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoServicoPrestado frame = new NovoServicoPrestado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public NovoServicoPrestado() {
		setTitle("Criar nova presta\u00E7\u00E3o de servi\u00E7o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblServico = new JLabel("Servi\u00E7o:");
		lblServico.setBounds(27, 25, 46, 14);
		contentPane.add(lblServico);

		JLabel lblRealizadoPor = new JLabel("Realizado por:");
		lblRealizadoPor.setBounds(27, 56, 92, 14);
		contentPane.add(lblRealizadoPor);

		JLabel lblPreco = new JLabel("Pre\u00E7o (R$):");
		lblPreco.setBounds(27, 87, 71, 14);
		contentPane.add(lblPreco);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(267, 87, 46, 14);
		contentPane.add(lblData);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(129, 84, 114, 20);
		contentPane.add(textValor);

		textData = new JTextField();
		textData.setBounds(312, 84, 106, 20);
		contentPane.add(textData);
		textData.setColumns(10);

		final JComboBox comboBoxBarbeiro = new JComboBox();
		comboBoxBarbeiro.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione um barbeiro" }));
		comboBoxBarbeiro.setBounds(129, 53, 289, 20);
		contentPane.add(comboBoxBarbeiro);

		final JComboBox comboBoxServico = new JComboBox();
		comboBoxServico.setModel(new DefaultComboBoxModel(new String[] {
				"Selecione um tipo de servi\u00E7o", "Barba", "Corte Adulto",
				"Corte Infantil" }));
		comboBoxServico.setMaximumRowCount(4);
		comboBoxServico.setBounds(129, 22, 289, 20);
		contentPane.add(comboBoxServico);

		try {
			Connection connection = FactoryConnection.getInstance().getConnection();
			java.sql.PreparedStatement pst = connection.prepareStatement("SELECT nome FROM barbeiro;");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				comboBoxBarbeiro.addItem(nome);
			}
			
		} catch (SQLException e) {
			mostrarMensagemDeErro(e.getMessage());
		}

		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ServicoPrestado servico_prestado = new ServicoPrestado();
					servico_prestado.setNomeBarbeiro(comboBoxBarbeiro.getSelectedItem().toString());
					servico_prestado.setNomeServico(comboBoxServico.getSelectedItem().toString());
					servico_prestado.setPreco(textValor.getText());
					servico_prestado.setData(textData.getText());

					if (comboBoxServico.getSelectedIndex() == 0)
						JOptionPane.showMessageDialog(null, "Voc� deve selecionar um tipo de servi�o.");
					else if (comboBoxBarbeiro.getSelectedIndex() == 0)
						JOptionPane.showMessageDialog(null,	"Voc� deve selecionar um barbeiro.");
					else {
						ServicoPrestadoController servicoController = ServicoPrestadoController.getInstance();
						servicoController.inserir(servico_prestado);

						JOptionPane.showMessageDialog(null, "Servico criado com sucesso");

						comboBoxBarbeiro.setSelectedIndex(0);
						comboBoxServico.setSelectedIndex(0);

						textValor.setText("");
						textData.setText("");
					}
				} catch (ServicoException e) {
					mostrarMensagemDeErro(e.getMessage());
				} catch (SQLException e) {
					mostrarMensagemDeErro(e.getMessage());
				}
			}
		});
		botaoSalvar.setBounds(27, 129, 89, 23);
		contentPane.add(botaoSalvar);

		JButton botaoLimparCampos = new JButton("Limpar Campos");
		botaoLimparCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textValor.setText("");
				textData.setText("");
			}
		});
		botaoLimparCampos.setBounds(152, 129, 148, 23);
		contentPane.add(botaoLimparCampos);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				CadastrarServicoPrestado frame = new CadastrarServicoPrestado();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		botaoVoltar.setBounds(329, 129, 89, 23);
		contentPane.add(botaoVoltar);
	}
	
	private void mostrarMensagemDeErro(String informacao) {
		JOptionPane.showMessageDialog(null, informacao, "Aten��o",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
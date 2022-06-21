package Trabalho;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Cad_Dados_Proj extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField Titulo_tf;
	private static JTextField Status_tf;
	private static JTextField Objetivo_tf;
	private static JTextField DataInicio_tf;
	private static JTextField Endereco_tf;
	

	/**
	 * Create the panel.
	 * @param listaDadosProjeto 
	 */
	public Cad_Dados_Proj() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setBounds(24, 164, 47, 14);
		add(lblTitulo);
		
		Titulo_tf = new JTextField();
		Titulo_tf.setBounds(81, 161, 155, 20);
		add(Titulo_tf);
		Titulo_tf.setColumns(10);
		
		JLabel lblObjetivo = new JLabel("Objetivo");
		lblObjetivo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObjetivo.setBounds(24, 80, 57, 14);
		add(lblObjetivo);
		
		Objetivo_tf = new JTextField();
		Objetivo_tf.setBounds(108, 77, 253, 20);
		add(Objetivo_tf);
		Objetivo_tf.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereco.setBounds(24, 35, 73, 14);
		add(lblEndereco);
		
		Endereco_tf = new JTextField();
		Endereco_tf.setBounds(108, 32, 253, 20);
		add(Endereco_tf);
		Endereco_tf.setColumns(10);
		
		JLabel lblDataInicio = new JLabel("Data de in\u00EDcio");
		lblDataInicio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataInicio.setBounds(24, 120, 86, 14);
		add(lblDataInicio);
		
		DataInicio_tf = new JTextField();
		DataInicio_tf.setBounds(118, 118, 118, 20);
		add(DataInicio_tf);
		DataInicio_tf.setColumns(10);
		
		Status_tf = new JTextField();
		Status_tf.setBounds(313, 161, 127, 20);
		add(Status_tf);
		Status_tf.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(257, 164, 46, 14);
		add(lblStatus);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.addActionListener(new ActionListener() {
			
			public static void escritorCadastro(String path) throws IOException {
				
			try {	
				BufferedWriter escrever = new BufferedWriter(new FileWriter(path, true));
				
				ArrayList<String> dados = new ArrayList<String>();
				
				if(Titulo_tf.getText().trim().isEmpty()
						|| Objetivo_tf.getText().trim().isEmpty()
						|| Endereco_tf.getText().trim().isEmpty()
						|| DataInicio_tf.getText().trim().isEmpty()
						|| Status_tf.getText().trim().isEmpty()) {
						
						JOptionPane.showMessageDialog(null, "Por gentileza preencher todos os campos", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				else {
					String Titulo = Titulo_tf.getText();
					String Objetivo = Objetivo_tf.getText();
					String Endereco = Endereco_tf.getText();
					String DataInicio = DataInicio_tf.getText();
					String Status = Status_tf.getText();
					
					
					dados.add("-----------------------------------------------"+"\r\n"+"Cadastro de dados do projeto: \r\n"
					+ "Título: " + Titulo + "\r\n"	
					+ "Objetivo: " + Objetivo + "\r\n"				
					+ "Endereço: " + Endereco + "\r\n"			
					+ "DataInicio: " + DataInicio + "\r\n"			
					+ "Status: " + Status+ "\r\n");
					
					String dadosString = String.join(" ", dados);
					
					escrever.append(dadosString);
											
					escrever.close();
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					
					Titulo_tf.setText("");
					Objetivo_tf.setText("");
					Endereco_tf.setText("");
					DataInicio_tf.setText("");
					Status_tf.setText("");
				}
			}
			
			catch(IOException e2) 
			{
				JOptionPane.showMessageDialog(null, "Erro!"+e2.getMessage());
			}
			
		}
			
			public void actionPerformed(ActionEvent e) {
				String path="projeto.txt";
				try {
					escritorCadastro(path.toString());
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente!");
				}
			}
		});
		
		btnSalvar.setBounds(81, 226, 111, 41);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Titulo_tf.setText("");
				Objetivo_tf.setText("");
				Endereco_tf.setText("");
				DataInicio_tf.setText("");
				Status_tf.setText("");
			}
		});
		btnLimpar.setBounds(250, 226, 111, 41);
		add(btnLimpar);

	}

}
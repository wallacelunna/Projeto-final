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

public class AgProj extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField Data_tf;
	private static JTextField Acao_tf;
	private static JTextField Hora_tf;
	private static JTextField Descricao_tf;
	

	/**
	 * Create the panel.
	 */
	public AgProj() {
		setLayout(null);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(24, 31, 46, 14);
		add(lblData);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHora.setBounds(236, 31, 46, 14);
		add(lblHora);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescricao.setBounds(24, 169, 66, 14);
		add(lblDescricao);
		
		JLabel lblAcao = new JLabel("A\u00E7\u00E3o");
		lblAcao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAcao.setBounds(24, 93, 46, 14);
		add(lblAcao);
		
		Data_tf = new JTextField();
		Data_tf.setBounds(100, 28, 100, 20);
		add(Data_tf);
		Data_tf.setColumns(10);
		
		Hora_tf = new JTextField();
		Hora_tf.setBounds(292, 28, 94, 20);
		add(Hora_tf);
		Hora_tf.setColumns(10);
		
		Descricao_tf = new JTextField();
		Descricao_tf.setBounds(100, 141, 286, 71);
		add(Descricao_tf);
		Descricao_tf.setColumns(10);
		
		Acao_tf = new JTextField();
		Acao_tf.setBounds(100, 91, 163, 20);
		add(Acao_tf);
		Acao_tf.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalvar.addActionListener(new ActionListener() {
			public static void escritorAgenda(String path) throws IOException {

			try {
				BufferedWriter escrever = new BufferedWriter(new FileWriter(path, true));
				
				ArrayList<String> agenda = new ArrayList<String>();
				
				if(Data_tf.getText().trim().isEmpty()
					|| Hora_tf.getText().trim().isEmpty()
					|| Descricao_tf.getText().trim().isEmpty()
					|| Acao_tf.getText().trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Por gentileza preencher todos os campos", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				
				else {		
						String Data = Data_tf.getText();
						String Hora = Hora_tf.getText();
						String Descricao = Descricao_tf.getText();
						String Acao = Acao_tf.getText();
						
					
						agenda.add("-----------------------------------------------"+"\r\n"+"Cadastro da agenda do projeto: " 
								+ "\r\n"+ "Data: " + Data + "\r\n"
								+ "Hora: " + Hora + "\r\n" 
								+ "Descrição: " + Descricao + "\r\n" 
								+ "Acao: " + Acao +"\r\n"
								);
								
						String agendaString = String.join(" ", agenda);
						
						escrever.append(agendaString);
						escrever.close();
						JOptionPane.showMessageDialog(null, "Agenda cadastrada com sucesso");
						
						Data_tf.setText("");
						Hora_tf.setText("");
						Descricao_tf.setText("");
						Acao_tf.setText("");
				}
				
			}
			catch(IOException e) {
					JOptionPane.showMessageDialog(null, "Erro!"+e.getMessage());
				}
			}
			
			public void actionPerformed(ActionEvent e) {
				String path="cadastro.txt";
				try {
					escritorAgenda(path.toString());
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente!");
				}
			}
				
			
		});
		btnSalvar.setBounds(100, 244, 100, 45);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data_tf.setText("");
				Hora_tf.setText("");
				Descricao_tf.setText("");
				Acao_tf.setText("");
			}
		});
		btnLimpar.setBounds(269, 244, 100, 45);
		add(btnLimpar);

	}
}
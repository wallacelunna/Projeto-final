package Trabalho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Proj extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Proj() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			
			public static void leitor(String path) throws IOException {
			
				try {	
				
				BufferedReader buffRead = new BufferedReader(new FileReader(path));
				String linha = "";
				String n="";
								
				while (true) {
					if (linha != null) {
						try {
							n = n + linha + "\n";
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else
						break;
					linha = buffRead.readLine();
				}
				buffRead.close();
				
				JTextArea textArea = new JTextArea(n);
				JScrollPane scrollPane = new JScrollPane(textArea);  
				textArea.setLineWrap(true);  
				textArea.setWrapStyleWord(true); 
				scrollPane.setPreferredSize( new Dimension( 300, 300 ) );
				JOptionPane.showMessageDialog(null, scrollPane, "Resultado", JOptionPane.INFORMATION_MESSAGE);
				}
				
				catch (IOException e) {
					
					JOptionPane.showMessageDialog(null, "Erro", "Ocorreu um erro, tente novamente!", JOptionPane.ERROR_MESSAGE);
					
				}
			}
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String path="projeto.txt";
					leitor(path.toString());
				
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "Erro", "Ocorreu um erro, tente novamente!", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			}
		);
		btnNewButton.setBounds(132, 187, 143, 54);
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Abrir o registro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(132, 71, 168, 36);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("de voluntariado");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_2.setBounds(132, 118, 168, 23);
		add(lblNewLabel_2);

	}
}
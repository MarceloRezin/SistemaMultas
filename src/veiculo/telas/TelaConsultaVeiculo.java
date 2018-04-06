package veiculo.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;

public class TelaConsultaVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public TelaConsultaVeiculo() {
		setTitle("Consulta De Veiculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 39, 220, 179);
		list.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setBounds(10, 8, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 226, 68, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(85, 226, 68, 23);
		contentPane.add(btnExcluir);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setBounds(163, 226, 68, 23);
		contentPane.add(btnNewButton);
		
		JButton btnP = new JButton("p");
		btnP.setBounds(151, 7, 40, 23);
		contentPane.add(btnP);
		
		JButton button = new JButton("+");
		button.setBounds(191, 7, 40, 23);
		contentPane.add(button);
	}
}

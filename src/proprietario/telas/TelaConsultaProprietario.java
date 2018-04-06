package proprietario.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaConsultaProprietario extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;

	public TelaConsultaProprietario() {
		super("Consulta De Proprietario", false, true, true, false);

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

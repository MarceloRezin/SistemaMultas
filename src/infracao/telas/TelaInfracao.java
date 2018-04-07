package infracao.telas;

import infracao.listenner.InfracaoCadastroListenner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaInfracao extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;

	public TelaInfracao() {
		super("Cadastro de Infração", false, true, true, false);
		setBounds(100, 100, 256, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descrição:");
		lblNewLabel.setBounds(10, 11, 50, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(110, 8, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMdelo = new JLabel("Gravidade:");
		lblMdelo.setBounds(10, 42, 38, 14);
		contentPane.add(lblMdelo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(110, 39, 121, 20);
		comboBox.addItem("Leve(3 pontos)");
		comboBox.addItem("Media(4 pontos)");
		comboBox.addItem("Grave(5 pontos)");
		comboBox.addItem("Gravissima(7 pontos)");		
		contentPane.add(comboBox);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 226, 68, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(85, 226, 68, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(163, 226, 68, 23);
		contentPane.add(btnVoltar);

		new InfracaoCadastroListenner(btnSalvar, btnExcluir, btnVoltar);
	}
}

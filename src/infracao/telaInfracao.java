package infracao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class telaInfracao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;

	public telaInfracao() {
		setTitle("Cadastro de Veiculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel.setBounds(10, 11, 33, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(110, 8, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMdelo = new JLabel("Tipo:");
		lblMdelo.setBounds(10, 42, 38, 14);
		contentPane.add(lblMdelo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(110, 39, 121, 20);
		comboBox.addItem("Leve(3 pontos)");
		comboBox.addItem("Media(4 pontos)");
		comboBox.addItem("Grave(5 pontos)");
		comboBox.addItem("Gravissima(7 pontos)");		
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Valor:");
		lblNewLabel_1.setBounds(10, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 70, 120, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 226, 96, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(134, 226, 96, 23);
		contentPane.add(btnExcluir);
	}
}

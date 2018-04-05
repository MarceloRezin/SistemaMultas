package proprietario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class telaProprietario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;


	public telaProprietario() {
		setTitle("Cadastro de Veiculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Marca:");
		lblNewLabel.setBounds(10, 11, 33, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(100, 8, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMdelo = new JLabel("Modelo:");
		lblMdelo.setBounds(10, 42, 38, 14);
		contentPane.add(lblMdelo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 39, 130, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ano:");
		lblNewLabel_1.setBounds(10, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 70, 130, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(10, 101, 46, 14);
		contentPane.add(lblUf);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(99, 98, 131, 20);
		contentPane.add(comboBox);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 126, 38, 14);
		contentPane.add(lblCidade);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 123, 130, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblRenavam = new JLabel("Renavam:");
		lblRenavam.setBounds(10, 151, 54, 14);
		contentPane.add(lblRenavam);
		
		JLabel lblCorPredominante = new JLabel("Cor Predominante:");
		lblCorPredominante.setBounds(10, 176, 96, 14);
		contentPane.add(lblCorPredominante);
		
		JLabel lblProprietario = new JLabel("Proprietario:");
		lblProprietario.setBounds(10, 201, 60, 14);
		contentPane.add(lblProprietario);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 173, 130, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(100, 148, 130, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(100, 198, 130, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 226, 96, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(134, 226, 96, 23);
		contentPane.add(btnExcluir);
	}
}

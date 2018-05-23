package cadastros.veiculo.telas;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cadastros.veiculo.Veiculo;

@SuppressWarnings("serial")
public class VeiculoCadastroTela extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtAno;
	private JTextField txtCidade;
	private JTextField txtCorPredominante;
	private JTextField txtRenavam;
	private JTextField txtProprietario;

	public VeiculoCadastroTela(Veiculo item) {
		super("Cadastro De Veiculo", false, true, true, false);
		setBounds(100, 100, 256, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 11, 33, 14);
		contentPane.add(lblMarca);

		txtMarca = new JTextField();
		txtMarca.setBounds(100, 8, 130, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);

		JLabel lblMdelo = new JLabel("Modelo:");
		lblMdelo.setBounds(10, 42, 38, 14);
		contentPane.add(lblMdelo);

		txtModelo = new JTextField();
		txtModelo.setBounds(100, 39, 130, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(10, 73, 46, 14);
		contentPane.add(lblAno);

		txtAno = new JTextField();
		txtAno.setBounds(100, 70, 130, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 101, 46, 14);
		contentPane.add(lblEstado);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(99, 98, 131, 20);
		contentPane.add(comboBox);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 126, 38, 14);
		contentPane.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(100, 123, 130, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblRenavam = new JLabel("Renavam:");
		lblRenavam.setBounds(10, 151, 54, 14);
		contentPane.add(lblRenavam);

		txtRenavam = new JTextField();
		txtRenavam.setBounds(100, 148, 130, 20);
		contentPane.add(txtRenavam);
		txtRenavam.setColumns(10);

		JLabel lblCorPredominante = new JLabel("Cor Predominante:");
		lblCorPredominante.setBounds(10, 176, 96, 14);
		contentPane.add(lblCorPredominante);

		txtCorPredominante = new JTextField();
		txtCorPredominante.setBounds(100, 173, 130, 20);
		contentPane.add(txtCorPredominante);
		txtCorPredominante.setColumns(10);

		JLabel lblProprietario = new JLabel("Proprietario:");
		lblProprietario.setBounds(10, 201, 60, 14);
		contentPane.add(lblProprietario);

		txtProprietario = new JTextField();
		txtProprietario.setBounds(100, 198, 130, 20);
		contentPane.add(txtProprietario);
		txtProprietario.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 226, 68, 23);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(88, 226, 68, 23);
		contentPane.add(btnExcluir);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(166, 226, 68, 23);
		contentPane.add(btnSair);
	}
}

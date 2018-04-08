package orgao.telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import infracao.listenner.InfracaoConsultaListenner;

@SuppressWarnings("serial")
public class OrgaoTelaConsulta extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;

	public OrgaoTelaConsulta(JDesktopPane jDesktopPane) {
		super("Consulta De Orgão", false, true, true, false);
		setBounds(100, 100, 256, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<Object> list = new JList<Object>();
		list.setBounds(10, 39, 220, 179);
		list.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		contentPane.add(list);
		
		textField = new JTextField();
		textField.setBounds(10, 8, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConsultar = new JButton("p");
		btnConsultar.setBounds(151, 7, 40, 23);
		contentPane.add(btnConsultar);
		
		JButton btnNovo = new JButton("+");
		btnNovo.setBounds(191, 7, 40, 23);
		contentPane.add(btnNovo);
		
		new InfracaoConsultaListenner(jDesktopPane, this, new OrgaoTelaCadastro(), btnConsultar, btnNovo, list);
	}
}

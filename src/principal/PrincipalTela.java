package principal;

import proprietario.Proprietario;
import proprietario.telas.TelaConsultaProprietario;
import proprietario.telas.TelaProprietario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PrincipalTela extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	public PrincipalTela() {
		setTitle("Sistema de Multas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);

		desktopPane = new JDesktopPane();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);


		TelaProprietario telaProprietario = new TelaProprietario();
		TelaConsultaProprietario telaConsultaProprietario = new TelaConsultaProprietario();
		desktopPane.add(telaConsultaProprietario);
		JMenuItem mntmProprietario = new JMenuItem("Proprietario");
		mntmProprietario.addActionListener( e -> {
			System.out.println("oi");
			telaConsultaProprietario.setVisible(true);
		});
		mnCadastro.add(mntmProprietario);
		
		JMenuItem mntmVeiculo = new JMenuItem("Veiculo");
		mnCadastro.add(mntmVeiculo);
		
		JMenuItem mntmOrgo = new JMenuItem("Org\u00E3o");
		mnCadastro.add(mntmOrgo);
		
		JMenuItem mntmInfrao = new JMenuItem("Infra\u00E7\u00E3o");
		mnCadastro.add(mntmInfrao);
		
		JMenuItem mntmMulta = new JMenuItem("Multa");
		mnCadastro.add(mntmMulta);
		
		JMenu mnConfiguraes = new JMenu("Configura\u00E7\u00F5es");
		menuBar.add(mnConfiguraes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setContentPane(desktopPane);


	}
}

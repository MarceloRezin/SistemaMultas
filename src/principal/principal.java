import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;

public class principal extends JFrame {

	private JPanel contentPane;

	public principal() {
		setTitle("Sistema de Multas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);

		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmProprietario = new JMenuItem("Proprietario");
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
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(59, 0, 375, 241);
		contentPane.add(internalFrame);
		internalFrame.setUI(null);
		internalFrame.setBorder(null);
		internalFrame.setVisible(true);
	}
}

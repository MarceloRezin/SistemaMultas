package principal;

import infracao.telas.TelaConsultaInfracao;
import multa.telas.TelaConsultaMulta;
import orgao.telas.TelaConsultaOrgao;
import proprietario.Proprietario;
import proprietario.telas.TelaConsultaProprietario;
import proprietario.telas.TelaProprietario;
import veiculo.telas.TelaConsultaVeiculo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PrincipalTela extends JFrame {

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

		TelaConsultaProprietario telaConsultaProprietario = new TelaConsultaProprietario(desktopPane);
		JMenuItem mntmProprietario = new JMenuItem("Proprietario");
		mntmProprietario.addActionListener( e -> {
			telaConsultaProprietario.setVisible(true);
			desktopPane.add(telaConsultaProprietario);
		});
		mnCadastro.add(mntmProprietario);

		TelaConsultaVeiculo telaConsultaVeiculo = new TelaConsultaVeiculo(desktopPane);
		JMenuItem mntmVeiculo = new JMenuItem("Veiculo");
		mnCadastro.add(mntmVeiculo);

		TelaConsultaOrgao telaConsultaOrgao = new TelaConsultaOrgao(desktopPane);
		JMenuItem mntmOrgo = new JMenuItem("Org\u00E3o");
		mnCadastro.add(mntmOrgo);

		TelaConsultaInfracao telaConsultaInfracao = new TelaConsultaInfracao(desktopPane);
		JMenuItem mntmInfrao = new JMenuItem("Infra\u00E7\u00E3o");
		mntmInfrao.addActionListener(e -> {
			telaConsultaInfracao.setVisible(true);
			desktopPane.add(telaConsultaInfracao);
		});
		mnCadastro.add(mntmInfrao);

		TelaConsultaMulta telaConsultaMulta = new TelaConsultaMulta(desktopPane);
		JMenuItem mntmMulta = new JMenuItem("Multa");
		mnCadastro.add(mntmMulta);


		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		mnSobre.addActionListener(e->{
			JOptionPane.showMessageDialog(null,"Lucas Claro \n Marcelo Rezin \n .1","Sobre",JOptionPane.INFORMATION_MESSAGE);
		});

		setContentPane(desktopPane);
	}
}

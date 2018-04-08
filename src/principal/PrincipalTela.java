package principal;

import infracao.telas.TelaConsultaInfracao;
import multa.telas.MultaTelaConsulta;
import orgao.telas.OrgaoTelaConsulta;
import proprietario.Proprietario;
import proprietario.telas.ProprietarioTelaConsulta;
import proprietario.telas.ProprietarioTelaCadastro;
import veiculo.telas.VeiculoTelaConsulta;

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

		ProprietarioTelaConsulta telaConsultaProprietario = new ProprietarioTelaConsulta(desktopPane);
		JMenuItem mntmProprietario = new JMenuItem("Proprietario");
		mntmProprietario.addActionListener( e -> {
			telaConsultaProprietario.setVisible(true);
			desktopPane.add(telaConsultaProprietario);
		});
		mnCadastro.add(mntmProprietario);

		VeiculoTelaConsulta telaConsultaVeiculo = new VeiculoTelaConsulta(desktopPane);
		JMenuItem mntmVeiculo = new JMenuItem("Veiculo");
		mnCadastro.add(mntmVeiculo);

		OrgaoTelaConsulta telaConsultaOrgao = new OrgaoTelaConsulta(desktopPane);
		JMenuItem mntmOrgo = new JMenuItem("Org\u00E3o");
		mnCadastro.add(mntmOrgo);

		TelaConsultaInfracao telaConsultaInfracao = new TelaConsultaInfracao(desktopPane);
		JMenuItem mntmInfrao = new JMenuItem("Infra\u00E7\u00E3o");
		mntmInfrao.addActionListener(e -> {
			telaConsultaInfracao.setVisible(true);
			desktopPane.add(telaConsultaInfracao);
		});
		mnCadastro.add(mntmInfrao);

		MultaTelaConsulta telaConsultaMulta = new MultaTelaConsulta(desktopPane);
		JMenuItem mntmMulta = new JMenuItem("Multa");
		mntmMulta.addActionListener(e -> {
		    telaConsultaMulta.setVisible(true);
		    desktopPane.add(telaConsultaMulta);
        });
		mnCadastro.add(mntmMulta);


		JMenu mnSobre = new JMenu("Sobre");
		JMenuItem mntSobre = new JMenuItem("Sobre o Software");
		mnSobre.add(mntSobre);
		menuBar.add(mnSobre);

		mntSobre.addActionListener(e->{
			JOptionPane.showMessageDialog(null,"Desenvolvedores: Lucas Claro e Marcelo Rezin \n Versão: 0.1","Sobre",JOptionPane.INFORMATION_MESSAGE);
		});

		setContentPane(desktopPane);
	}
}

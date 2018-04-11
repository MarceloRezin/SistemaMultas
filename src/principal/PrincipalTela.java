package principal;

import infracao.telas.InfracaoConsultaTela;
import multa.telas.MultaTelaConsulta;
import orgao.telas.OrgaoTelaConsulta;
import proprietario.Proprietario;
import proprietario.telas.ProprietarioConsultaTela;
import proprietario.telas.ProprietarioTelaCadastro;
import veiculo.telas.VeiculoTelaConsulta;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

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

//		ProprietarioConsultaTela telaConsultaProprietario = new ProprietarioConsultaTela(desktopPane);
		JMenuItem mntmProprietario = new JMenuItem("Proprietario");
//		mntmProprietario.addActionListener( e -> {
//			telaConsultaProprietario.setVisible(true);
//			desktopPane.add(telaConsultaProprietario);
//		});
		mnCadastro.add(mntmProprietario);

//		VeiculoTelaConsulta telaConsultaVeiculo = new VeiculoTelaConsulta(desktopPane);
		JMenuItem mntmVeiculo = new JMenuItem("Veiculo");
		mnCadastro.add(mntmVeiculo);

//		OrgaoTelaConsulta telaConsultaOrgao = new OrgaoTelaConsulta(desktopPane);
		JMenuItem mntmOrgo = new JMenuItem("Org\u00E3o");
		mnCadastro.add(mntmOrgo);

		JMenuItem mntmInfracao = new JMenuItem("Infração");
		mntmInfracao.addActionListener(e -> {
			InfracaoConsultaTela telaConsultaInfracao = new InfracaoConsultaTela(desktopPane, null);
			telaConsultaInfracao.setVisible(true);
			desktopPane.add(telaConsultaInfracao);
		});
		mnCadastro.add(mntmInfracao);

//		MultaTelaConsulta telaConsultaMulta = new MultaTelaConsulta(desktopPane);
		JMenuItem mntmMulta = new JMenuItem("Multa");
//		mntmMulta.addActionListener(e -> {
//		    telaConsultaMulta.setVisible(true);
//		    desktopPane.add(telaConsultaMulta);
//        });
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

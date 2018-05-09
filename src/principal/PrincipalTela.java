package principal;

import banco.Banco;
import gravidademulta.telas.GravidadeMultaConsultaTela;
import infracao.telas.InfracaoConsultaTela;
import multa.telas.MultaConsultaTela;
import orgao.telas.OrgaoConsultaTela;
import proprietario.telas.ProprietarioConsultaTela;
import usuario.telas.UsuarioConsultaTela;
import veiculo.telas.VeiculoConsultaTela;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PrincipalTela extends JFrame {
	private JDesktopPane desktopPane;

	public PrincipalTela() {
		setTitle("Sistema de Multas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);

		desktopPane = new JDesktopPane();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);

		JMenuItem mntmProprietario = new JMenuItem("Proprietario");
		mntmProprietario.addActionListener( e -> {
			ProprietarioConsultaTela proprietarioConsultaTela = new ProprietarioConsultaTela(desktopPane, null);
			proprietarioConsultaTela.setVisible(true);
			desktopPane.add(proprietarioConsultaTela);
		});
		mnCadastro.add(mntmProprietario);

		JMenuItem mntmVeiculo = new JMenuItem("Veiculo");
		mntmVeiculo.addActionListener( e -> {
			VeiculoConsultaTela veiculoConsultaTela = new VeiculoConsultaTela(desktopPane, null);
			veiculoConsultaTela.setVisible(true);
			desktopPane.add(veiculoConsultaTela);
		});
		mnCadastro.add(mntmVeiculo);

		JMenuItem mntmOrgo = new JMenuItem("Orgão");
		mntmOrgo.addActionListener( e -> {
			OrgaoConsultaTela orgaoConsultaTela = new OrgaoConsultaTela(desktopPane, null);
			orgaoConsultaTela.setVisible(true);
			desktopPane.add(orgaoConsultaTela);
		});
		mnCadastro.add(mntmOrgo);

		JMenuItem mntmGravidadeMulta = new JMenuItem("Gravidade das Multas");
        mntmGravidadeMulta.addActionListener(e -> {
            GravidadeMultaConsultaTela gravidadeMultaConsultaTela = new GravidadeMultaConsultaTela(desktopPane);
            gravidadeMultaConsultaTela.setVisible(true);
			desktopPane.add(gravidadeMultaConsultaTela);
		});
		mnCadastro.add(mntmGravidadeMulta);

		JMenuItem mntmInfracao = new JMenuItem("Infração");
		mntmInfracao.addActionListener(e -> {
			InfracaoConsultaTela telaConsultaInfracao = new InfracaoConsultaTela(desktopPane, null);
			telaConsultaInfracao.setVisible(true);
			desktopPane.add(telaConsultaInfracao);
		});
		mnCadastro.add(mntmInfracao);

		JMenuItem mntmMulta = new JMenuItem("Multa");
		mntmMulta.addActionListener(e -> {
			MultaConsultaTela telaConsultaMulta = new MultaConsultaTela(desktopPane, null);
		    telaConsultaMulta.setVisible(true);
		    desktopPane.add(telaConsultaMulta);
        });
		mnCadastro.add(mntmMulta);
		
		JMenu mnUsuario = new JMenu("Usuarios");
		JMenuItem gerenciarUsuarios = new JMenuItem("Gerenciar Usuários");
		gerenciarUsuarios.addActionListener( e -> {
			UsuarioConsultaTela usuarioConsultaTela = new UsuarioConsultaTela(desktopPane, null);
			usuarioConsultaTela.setVisible(true);
			desktopPane.add(usuarioConsultaTela);
		});
		mnUsuario.add(gerenciarUsuarios);
		menuBar.add(mnUsuario);


		JMenu mnSobre = new JMenu("Sobre");
		JMenuItem mntSobre = new JMenuItem("Sobre o Software");
		mnSobre.add(mntSobre);
		menuBar.add(mnSobre);
		mntSobre.addActionListener(e->{
			JOptionPane.showMessageDialog(null,"Desenvolvedores: Lucas Claro e Marcelo Rezin \n Versão: 0.1","Sobre",JOptionPane.INFORMATION_MESSAGE);
		});

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Banco.fecharConexao();
                super.windowClosing(e);
            }
        });

		setContentPane(desktopPane);
	}
}

package principal;

import banco.Banco;
import cadastros.cidade.telas.CidadeConsultaTela;
import cadastros.condutor.Condutor;
import cadastros.condutor.telas.CondutorConsultaTela;
import cadastros.gravidademulta.telas.GravidadeMultaConsultaTela;
import cadastros.pessoa.fisica.telas.PessoaFisicaConsultaTela;
import cadastros.pessoa.juridica.telas.PessoaJuridicaConsultaTela;
import cadastros.proprietario.telas.ProprietarioConsultaTela;
import log.Logger;

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

        JMenuItem mntmCidade = new JMenuItem("Cidades");
        mntmCidade.addActionListener(e -> {
            CidadeConsultaTela cidadeConsultaTela = new CidadeConsultaTela(desktopPane);
            cidadeConsultaTela.setVisible(true);
            desktopPane.add(cidadeConsultaTela);
        });
        mnCadastro.add(mntmCidade);

		JMenuItem mntmGravidadeMulta = new JMenuItem("Gravidade das Multas");
		mntmGravidadeMulta.addActionListener(e -> {
			GravidadeMultaConsultaTela gravidadeMultaConsultaTela = new GravidadeMultaConsultaTela(desktopPane);
			gravidadeMultaConsultaTela.setVisible(true);
			desktopPane.add(gravidadeMultaConsultaTela);
		});
		mnCadastro.add(mntmGravidadeMulta);

        JMenuItem mntmPessoaFisica = new JMenuItem("Pessoas Físicas");
        mntmPessoaFisica.addActionListener(e -> {
            PessoaFisicaConsultaTela pessoaFisicaConsultaTela = new PessoaFisicaConsultaTela(desktopPane);
            pessoaFisicaConsultaTela.setVisible(true);
            desktopPane.add(pessoaFisicaConsultaTela);
        });
        mnCadastro.add(mntmPessoaFisica);

        JMenuItem mntmPessoaJuridica = new JMenuItem("Pessoas Jurídicas");
		mntmPessoaJuridica.addActionListener(e -> {
            PessoaJuridicaConsultaTela pessoaJuridicaConsultaTela = new PessoaJuridicaConsultaTela(desktopPane);
			pessoaJuridicaConsultaTela.setVisible(true);
            desktopPane.add(pessoaJuridicaConsultaTela);
        });
        mnCadastro.add(mntmPessoaJuridica);

        JMenuItem mntmCondutor = new JMenuItem("Condutores");
        mntmCondutor.addActionListener(e -> {
            CondutorConsultaTela condutorConsultaTela = new CondutorConsultaTela(desktopPane);
            condutorConsultaTela.setVisible(true);
            desktopPane.add(condutorConsultaTela);
        });
        mnCadastro.add(mntmCondutor);

        JMenuItem mntmProprietario = new JMenuItem("Proprietários");
        mntmProprietario.addActionListener(e -> {
            ProprietarioConsultaTela proprietarioConsultaTela= new ProprietarioConsultaTela(desktopPane);
            proprietarioConsultaTela.setVisible(true);
            desktopPane.add(proprietarioConsultaTela);
        });
        mnCadastro.add(mntmProprietario);

//		JMenuItem mntmProprietario = new JMenuItem("Proprietario");
//		mntmProprietario.addActionListener( e -> {
//			ProprietarioConsultaTela proprietarioConsultaTela = new ProprietarioConsultaTela(desktopPane);
//			proprietarioConsultaTela.setVisible(true);
//			desktopPane.add(proprietarioConsultaTela);
//		});
//		mnCadastro.add(mntmProprietario);

//		JMenuItem mntmVeiculo = new JMenuItem("Veiculo");
//		mntmVeiculo.addActionListener( e -> {
//			VeiculoConsultaTela veiculoConsultaTela = new VeiculoConsultaTela(desktopPane);
//			veiculoConsultaTela.setVisible(true);
//			desktopPane.add(veiculoConsultaTela);
//		});
//		mnCadastro.add(mntmVeiculo);

//		JMenuItem mntmOrgo = new JMenuItem("Orgão");
//		mntmOrgo.addActionListener( e -> {
//			OrgaoConsultaTela orgaoConsultaTela = new OrgaoConsultaTela(desktopPane);
//			orgaoConsultaTela.setVisible(true);
//			desktopPane.add(orgaoConsultaTela);
//		});
//		mnCadastro.add(mntmOrgo);


//		JMenuItem mntmInfracao = new JMenuItem("Infração");
//		mntmInfracao.addActionListener(e -> {
//			InfracaoConsultaTela telaConsultaInfracao = new InfracaoConsultaTela(desktopPane);
//			telaConsultaInfracao.setVisible(true);
//			desktopPane.add(telaConsultaInfracao);
//		});
//		mnCadastro.add(mntmInfracao);
//
//		JMenuItem mntmMulta = new JMenuItem("Multa");
//		mntmMulta.addActionListener(e -> {
//			MultaConsultaTela telaConsultaMulta = new MultaConsultaTela(desktopPane);
//		    telaConsultaMulta.setVisible(true);
//		    desktopPane.add(telaConsultaMulta);
//        });
//		mnCadastro.add(mntmMulta);

//		JMenu mnUsuario = new JMenu("Usuarios");
//		JMenuItem gerenciarUsuarios = new JMenuItem("Gerenciar Usuários");
//		gerenciarUsuarios.addActionListener( e -> {
//			UsuarioConsultaTela usuarioConsultaTela = new UsuarioConsultaTela(desktopPane);
//			usuarioConsultaTela.setVisible(true);
//			desktopPane.add(usuarioConsultaTela);
//		});
//		mnUsuario.add(gerenciarUsuarios);
//		menuBar.add(mnUsuario);


		JMenu mnSobre = new JMenu("Sobre");
		JMenuItem mntSobre = new JMenuItem("Sobre o Software");
		mnSobre.add(mntSobre);
		menuBar.add(mnSobre);
		mntSobre.addActionListener(e->{
			JOptionPane.showMessageDialog(null,"Desenvolvedores: Lucas Claro e Marcelo Rezin \n Versão: 0.2","Sobre",JOptionPane.INFORMATION_MESSAGE);
			Logger.log("Menu Sobre");
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

package principal;

import banco.Banco;
import cadastros.cidade.telas.CidadeConsultaTela;
import cadastros.condutor.telas.CondutorConsultaTela;
import cadastros.gravidademulta.telas.GravidadeMultaConsultaTela;
import cadastros.infracao.telas.InfracaoConsultaTela;
import cadastros.multa.telas.MultaConsultaTela;
import cadastros.orgao.telas.OrgaoConsultaTela;
import cadastros.pessoa.fisica.telas.PessoaFisicaConsultaTela;
import cadastros.pessoa.juridica.telas.PessoaJuridicaConsultaTela;
import cadastros.proprietario.telas.ProprietarioConsultaTela;
import cadastros.usuario.UsuarioContexto;
import cadastros.usuario.login.UsuarioLoginTela;
import cadastros.usuario.telas.UsuarioConsultaTela;
import cadastros.veiculo.telas.VeiculoConsultaTela;
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
            Logger.log("Consulta Cidades");
        });
        mnCadastro.add(mntmCidade);

		JMenuItem mntmGravidadeMulta = new JMenuItem("Gravidade das Multas");
		mntmGravidadeMulta.addActionListener(e -> {
			GravidadeMultaConsultaTela gravidadeMultaConsultaTela = new GravidadeMultaConsultaTela(desktopPane);
			gravidadeMultaConsultaTela.setVisible(true);
			desktopPane.add(gravidadeMultaConsultaTela);
            Logger.log("Consulta Gravidade das Multas");
		});
		mnCadastro.add(mntmGravidadeMulta);

        JMenuItem mntmPessoaFisica = new JMenuItem("Pessoas Físicas");
        mntmPessoaFisica.addActionListener(e -> {
            PessoaFisicaConsultaTela pessoaFisicaConsultaTela = new PessoaFisicaConsultaTela(desktopPane);
            pessoaFisicaConsultaTela.setVisible(true);
            desktopPane.add(pessoaFisicaConsultaTela);
            Logger.log("Consulta Pessoas Físicas");
        });
        mnCadastro.add(mntmPessoaFisica);

        JMenuItem mntmPessoaJuridica = new JMenuItem("Pessoas Jurídicas");
		mntmPessoaJuridica.addActionListener(e -> {
            PessoaJuridicaConsultaTela pessoaJuridicaConsultaTela = new PessoaJuridicaConsultaTela(desktopPane);
			pessoaJuridicaConsultaTela.setVisible(true);
            desktopPane.add(pessoaJuridicaConsultaTela);
            Logger.log("Consulta Pessoas Jurídicas");
        });
        mnCadastro.add(mntmPessoaJuridica);

        JMenuItem mntmCondutor = new JMenuItem("Condutores");
        mntmCondutor.addActionListener(e -> {
            CondutorConsultaTela condutorConsultaTela = new CondutorConsultaTela(desktopPane);
            condutorConsultaTela.setVisible(true);
            desktopPane.add(condutorConsultaTela);
            Logger.log("Consulta Condutores");
        });
        mnCadastro.add(mntmCondutor);

        JMenuItem mntmProprietario = new JMenuItem("Proprietários");
        mntmProprietario.addActionListener(e -> {
            ProprietarioConsultaTela proprietarioConsultaTela= new ProprietarioConsultaTela(desktopPane);
            proprietarioConsultaTela.setVisible(true);
            desktopPane.add(proprietarioConsultaTela);
            Logger.log("Consulta Proprietários");
        });
        mnCadastro.add(mntmProprietario);

        JMenuItem mntmVeiculo = new JMenuItem("Veículos");
        mntmVeiculo.addActionListener( e -> {
            VeiculoConsultaTela veiculoConsultaTela = new VeiculoConsultaTela(desktopPane);
            veiculoConsultaTela.setVisible(true);
            desktopPane.add(veiculoConsultaTela);
            Logger.log("Consulta Veículos");
        });
        mnCadastro.add(mntmVeiculo);


		JMenuItem mntmOrgao = new JMenuItem("Orgãos");
		mntmOrgao.addActionListener( e -> {
			OrgaoConsultaTela orgaoConsultaTela = new OrgaoConsultaTela(desktopPane);
			orgaoConsultaTela.setVisible(true);
			desktopPane.add(orgaoConsultaTela);
            Logger.log("Consulta Orgãos");
		});
		mnCadastro.add(mntmOrgao);

		JMenuItem mntmInfracao = new JMenuItem("Infrações");
		mntmInfracao.addActionListener(e -> {
			InfracaoConsultaTela telaConsultaInfracao = new InfracaoConsultaTela(desktopPane);
			telaConsultaInfracao.setVisible(true);
			desktopPane.add(telaConsultaInfracao);
            Logger.log("Consulta Infrações");
		});
		mnCadastro.add(mntmInfracao);

		JMenuItem mntmMulta = new JMenuItem("Multas");
		mntmMulta.addActionListener(e -> {
			MultaConsultaTela telaConsultaMulta = new MultaConsultaTela(desktopPane);
		    telaConsultaMulta.setVisible(true);
		    desktopPane.add(telaConsultaMulta);
            Logger.log("Consulta Multas");
        });
		mnCadastro.add(mntmMulta);

		if(UsuarioContexto.getUsuarioLogado().isAdmin()){
			JMenu mnUsuario = new JMenu("Usuários");
			JMenuItem gerenciarUsuarios = new JMenuItem("Gerenciar Usuários");
			gerenciarUsuarios.addActionListener( e -> {
				UsuarioConsultaTela usuarioConsultaTela = new UsuarioConsultaTela(desktopPane);
				usuarioConsultaTela.setVisible(true);
				desktopPane.add(usuarioConsultaTela);
                Logger.log("Consulta Usuários");
			});
			mnUsuario.add(gerenciarUsuarios);
			menuBar.add(mnUsuario);
		}

		JMenu mnOpcoes = new JMenu("Opções");
		JMenuItem mntSobre = new JMenuItem("Sobre o Software");
		mnOpcoes.add(mntSobre);
		menuBar.add(mnOpcoes);
		mntSobre.addActionListener(e->{
			JOptionPane.showMessageDialog(null,"Desenvolvedores: Lucas Claro e Marcelo Rezin \n Versão: 2.0","Sobre",JOptionPane.INFORMATION_MESSAGE);
		});

		JMenuItem mntSair = new JMenuItem("Sair");
        mnOpcoes.add(mntSair);
        mntSair.addActionListener(e->{
            Logger.log("Sair");
			UsuarioContexto.setUsuarioLogado(null);
            new UsuarioLoginTela().setVisible(true);
            dispose();
		});

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Logger.log("Fechar");
                Banco.fecharConexao();
                super.windowClosing(e);
            }
        });

		setContentPane(desktopPane);
	}
}

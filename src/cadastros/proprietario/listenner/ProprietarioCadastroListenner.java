package cadastros.proprietario.listenner;

import cadastros.condutor.telas.CondutorConsultaTela;
import cadastros.pessoa.consulta.tela.PessoaConsultaTela;
import cadastros.proprietario.telas.ProprietarioCadastroTela;
import commons.listenners.CadastroListenner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProprietarioCadastroListenner extends CadastroListenner  implements ActionListener {

    private JButton btnSelecionarPessoa;
    private JButton btnSelecionarCondutor;
    private ProprietarioCadastroTela proprietarioCadastroTela;

    public ProprietarioCadastroListenner(ProprietarioCadastroTela cadastroTela) {
        super(cadastroTela);
        this.proprietarioCadastroTela = cadastroTela;
        this.btnSelecionarPessoa = cadastroTela.getBtnSelecionarPessoa();
        this.btnSelecionarCondutor = cadastroTela.getBtnSelecionarCondutor();

        this.btnSelecionarPessoa.addActionListener(this);
        this.btnSelecionarCondutor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnSelecionarPessoa){
            eventoSelecionarPessoa();
        }else if(evento.getSource() == btnSelecionarCondutor){
            eventoSelecionarCondutor();
        }else{
            super.actionPerformed(evento);
        }
    }

    private void eventoSelecionarPessoa(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        PessoaConsultaTela pessoaConsultaTela = new PessoaConsultaTela(getCadastroTela(), proprietarioCadastroTela.getPessoa(), proprietarioCadastroTela.getLblPessoa());
        desktopPane.add(pessoaConsultaTela);
        pessoaConsultaTela.setVisible(true);
    }

    private void eventoSelecionarCondutor(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        CondutorConsultaTela cidadeConsultaTela = new CondutorConsultaTela(getCadastroTela(), proprietarioCadastroTela.getCondutor(), proprietarioCadastroTela.getLblCondutor());
        desktopPane.add(cidadeConsultaTela);
        cidadeConsultaTela.setVisible(true);

    }
}

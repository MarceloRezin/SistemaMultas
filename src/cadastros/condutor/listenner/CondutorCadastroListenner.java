package cadastros.condutor.listenner;

import cadastros.condutor.telas.CondutorCadastroTela;
import cadastros.pessoa.fisica.telas.PessoaFisicaConsultaTela;
import commons.listenners.CadastroListenner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CondutorCadastroListenner extends CadastroListenner implements ActionListener{

    private JButton btnSelecionarPessoa;
    private CondutorCadastroTela cadastroTela;

    public CondutorCadastroListenner(CondutorCadastroTela cadastroTela) {
        super(cadastroTela);
        this.cadastroTela = cadastroTela;
        this.btnSelecionarPessoa = cadastroTela.getBtnSelecionarPessoa();
        btnSelecionarPessoa.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnSelecionarPessoa){
            eventoSelecionarPessoa();
        }else {
            super.actionPerformed(evento);
        }
    }

    private void eventoSelecionarPessoa(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        PessoaFisicaConsultaTela pessoaFisicaConsultaTela = new PessoaFisicaConsultaTela(getCadastroTela(), cadastroTela.getPessoa(), cadastroTela.getLblPessoa());
        desktopPane.add(pessoaFisicaConsultaTela);
        pessoaFisicaConsultaTela.setVisible(true);
    }
}
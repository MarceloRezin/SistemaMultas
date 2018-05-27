package cadastros.pessoa.fisica.listenner;

import cadastros.cidade.telas.CidadeConsultaTela;
import cadastros.pessoa.fisica.telas.PessoaFisicaCadastroTela;
import commons.listenners.CadastroListenner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PessoaFisicaCadastroListenner extends CadastroListenner implements ActionListener{

    private JButton btnSelecionarCidade;
    private PessoaFisicaCadastroTela cadastroTela;

    public PessoaFisicaCadastroListenner(PessoaFisicaCadastroTela cadastroTela) {
        super(cadastroTela);
        this.cadastroTela = cadastroTela;
        this.btnSelecionarCidade = cadastroTela.getBtnSelecionarCidade();
        btnSelecionarCidade.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnSelecionarCidade){
            eventoSelecionarCidade();
        }else {
            super.actionPerformed(evento);
        }
    }

    private void eventoSelecionarCidade(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        System.out.println(cadastroTela.getCidade());
        CidadeConsultaTela cidadeConsultaTela = new CidadeConsultaTela(getCadastroTela(), cadastroTela.getCidade(), cadastroTela.getLblCidade());
        desktopPane.add(cidadeConsultaTela);
        cidadeConsultaTela.setVisible(true);
    }
}

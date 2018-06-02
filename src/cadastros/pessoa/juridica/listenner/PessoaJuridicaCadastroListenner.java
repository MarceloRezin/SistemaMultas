package cadastros.pessoa.juridica.listenner;

import cadastros.cidade.telas.CidadeConsultaTela;
import cadastros.pessoa.juridica.telas.PessoaJuridicaCadastroTela;
import commons.listenners.CadastroListenner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PessoaJuridicaCadastroListenner extends CadastroListenner implements ActionListener{

    private JButton btnSelecionarCidade;
    private PessoaJuridicaCadastroTela cadastroTela;

    public PessoaJuridicaCadastroListenner(PessoaJuridicaCadastroTela cadastroTela) {
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
        CidadeConsultaTela cidadeConsultaTela = new CidadeConsultaTela(getCadastroTela(), cadastroTela.getCidade(), cadastroTela.getLblCidade());
        desktopPane.add(cidadeConsultaTela);
        cidadeConsultaTela.setVisible(true);
    }
}

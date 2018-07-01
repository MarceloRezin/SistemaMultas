package cadastros.veiculo.listenner;

import cadastros.cidade.telas.CidadeConsultaTela;
import cadastros.proprietario.telas.ProprietarioConsultaTela;
import cadastros.veiculo.telas.VeiculoCadastroTela;
import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;
import log.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeiculoCadastroListenner extends CadastroListenner implements ActionListener{

    private JButton btnSelecionarCidade;
    private JButton btnSelecionarProprietario;
    private VeiculoCadastroTela veiculoCadastroTela;

    public VeiculoCadastroListenner(VeiculoCadastroTela cadastroTela) {
        super(cadastroTela);

        this.veiculoCadastroTela = cadastroTela;
        this.btnSelecionarCidade = cadastroTela.getBtnSelecionarCidade();
        this.btnSelecionarProprietario = cadastroTela.getBtnSelecionarProprietario();

        btnSelecionarCidade.addActionListener(this);
        btnSelecionarProprietario.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnSelecionarCidade){
            eventoSelecionarCidade();
        }else if(evento.getSource() == btnSelecionarProprietario){
            eventoSelecionarProprietario();
        }else{
            super.actionPerformed(evento);
        }
    }

    private void eventoSelecionarCidade(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        CidadeConsultaTela pessoaConsultaTela = new CidadeConsultaTela(getCadastroTela(), veiculoCadastroTela.getCidade(), veiculoCadastroTela.getLblCidade());
        desktopPane.add(pessoaConsultaTela);
        pessoaConsultaTela.setVisible(true);
    }

    private void eventoSelecionarProprietario(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        ProprietarioConsultaTela proprietarioConsultaTela = new ProprietarioConsultaTela(getCadastroTela(), veiculoCadastroTela.getProprietario(), veiculoCadastroTela.getLblProprietario());
        desktopPane.add(proprietarioConsultaTela);
        proprietarioConsultaTela.setVisible(true);
    }
}

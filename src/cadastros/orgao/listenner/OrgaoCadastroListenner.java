package cadastros.orgao.listenner;

import cadastros.cidade.telas.CidadeConsultaTela;
import cadastros.orgao.telas.OrgaoCadastroTela;
import commons.listenners.CadastroListenner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgaoCadastroListenner extends CadastroListenner implements ActionListener{

    private JButton btnSelecionarCidade;
    private OrgaoCadastroTela orgaoCadastroTela;

    public OrgaoCadastroListenner(OrgaoCadastroTela cadastroTela) {
        super(cadastroTela);
        this.orgaoCadastroTela = cadastroTela;
        this.btnSelecionarCidade = cadastroTela.getBtnSelecionarCidade();
        btnSelecionarCidade.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnSelecionarCidade){
            eventoSelecionarCidade();
        }else{
            super.actionPerformed(evento);
        }
    }

    private void eventoSelecionarCidade(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        CidadeConsultaTela cidadeConsultaTela = new CidadeConsultaTela(getCadastroTela(), orgaoCadastroTela.getCidade(), orgaoCadastroTela.getLblCidade());
        desktopPane.add(cidadeConsultaTela);
        cidadeConsultaTela.setVisible(true);
    }
}

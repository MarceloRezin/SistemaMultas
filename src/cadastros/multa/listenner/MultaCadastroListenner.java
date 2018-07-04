package cadastros.multa.listenner;

import cadastros.cidade.telas.CidadeConsultaTela;
import cadastros.condutor.telas.CondutorConsultaTela;
import cadastros.infracao.telas.InfracaoConsultaTela;
import cadastros.multa.telas.MultaCadastroTela;
import cadastros.orgao.telas.OrgaoConsultaTela;
import cadastros.veiculo.telas.VeiculoConsultaTela;
import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;
import log.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultaCadastroListenner extends CadastroListenner implements ActionListener{

    private JButton btnSelecionarVeiculo;
    private JButton btnSelecionarOrgao;
    private JButton btnSelecionarInfracao;
    private JButton btnSelecionarCidade;
    private JButton btnSelecionarCondutor;

    private MultaCadastroTela cadastroTela;

    public MultaCadastroListenner(MultaCadastroTela cadastroTela) {
        super(cadastroTela);
        this.cadastroTela = cadastroTela;

        this.btnSelecionarVeiculo = cadastroTela.getBtnSelecionarVeiculo();
        this.btnSelecionarVeiculo.addActionListener(this);

        this.btnSelecionarOrgao = cadastroTela.getBtnSelecionarOrgao();
        this.btnSelecionarOrgao.addActionListener(this);

        this.btnSelecionarInfracao = cadastroTela.getBtnSelecionarInfracao();
        this.btnSelecionarInfracao.addActionListener(this);

        this.btnSelecionarCidade = cadastroTela.getBtnSelecionarCidade();
        this.btnSelecionarCidade.addActionListener(this);

        this.btnSelecionarCondutor = cadastroTela.getBtnSelecionarCondutor();
        this.btnSelecionarCondutor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        Object source = evento.getSource();
        if(source == btnSelecionarVeiculo){
            eventoSelecionarVeiculo();
        }else if(source == btnSelecionarOrgao){
            eventoSelecionarOrgao();
        }else if(source == btnSelecionarInfracao){
            eventoSelecionarInfracao();
        }else if(source == btnSelecionarCidade){
            eventoSelecionarCidade();
        }else if(source == btnSelecionarCondutor){
            eventoSelecionarCondutor();
        } else{
            super.actionPerformed(evento);
        }

    }

    private void eventoSelecionarVeiculo(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        VeiculoConsultaTela veiculoConsultaTela = new VeiculoConsultaTela(getCadastroTela(), cadastroTela.getVeiculo(), cadastroTela.getLblVeiculo());
        desktopPane.add(veiculoConsultaTela);
        veiculoConsultaTela.setVisible(true);
    }

    private void eventoSelecionarOrgao(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        OrgaoConsultaTela orgaoConsultaTela = new OrgaoConsultaTela(getCadastroTela(), cadastroTela.getOrgao(), cadastroTela.getLblOrgao());
        desktopPane.add(orgaoConsultaTela);
        orgaoConsultaTela.setVisible(true);
    }

    private void eventoSelecionarInfracao(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        InfracaoConsultaTela infracaoConsultaTela = new InfracaoConsultaTela(getCadastroTela(), cadastroTela.getInfracao(), cadastroTela.getLblInfracao());
        desktopPane.add(infracaoConsultaTela);
        infracaoConsultaTela.setVisible(true);
    }

    private void eventoSelecionarCidade(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        CidadeConsultaTela cidadeConsultaTela = new CidadeConsultaTela(getCadastroTela(), cadastroTela.getCidade(), cadastroTela.getLblCidade());
        desktopPane.add(cidadeConsultaTela);
        cidadeConsultaTela.setVisible(true);
    }

    private void eventoSelecionarCondutor(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        CondutorConsultaTela condutorConsultaTela = new CondutorConsultaTela(getCadastroTela(), cadastroTela.getCondutor(), cadastroTela.getLblCondutor());
        desktopPane.add(condutorConsultaTela);
        condutorConsultaTela.setVisible(true);
    }
}

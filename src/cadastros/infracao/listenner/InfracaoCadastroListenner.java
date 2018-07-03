package cadastros.infracao.listenner;

import cadastros.gravidademulta.telas.GravidadeMultaConsultaTela;
import cadastros.infracao.telas.InfracaoCadastroTela;
import commons.listenners.CadastroListenner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfracaoCadastroListenner extends CadastroListenner implements ActionListener{

    private JButton btnSelecionarGravidadeMulta;
    private InfracaoCadastroTela cadastroTela;

    public InfracaoCadastroListenner(InfracaoCadastroTela cadastroTela) {
        super(cadastroTela);
        this.cadastroTela = cadastroTela;
        this.btnSelecionarGravidadeMulta = cadastroTela.getBtnGravidadeMulta();

        btnSelecionarGravidadeMulta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnSelecionarGravidadeMulta){
            eventoSelecionarGravidadeMulta();
        }else{
            super.actionPerformed(evento);
        }
    }

    private void eventoSelecionarGravidadeMulta(){
        JDesktopPane desktopPane = getCadastroTela().getConsultaTela().getjDesktopPane();
        GravidadeMultaConsultaTela gravidadeMultaConsultaTela = new GravidadeMultaConsultaTela(getCadastroTela(), cadastroTela.getGravidadeMulta(), cadastroTela.getLblGravidadeMulta());
        desktopPane.add(gravidadeMultaConsultaTela);
        gravidadeMultaConsultaTela.setVisible(true);
    }
}

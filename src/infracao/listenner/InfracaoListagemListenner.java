package infracao.listenner;

import commons.listenners.ListagemListenner;
import infracao.telas.TelaInfracao;

import javax.swing.*;

public class InfracaoListagemListenner extends ListagemListenner {
    private JDesktopPane jDesktopPane;
    private TelaInfracao telaInfracao = new TelaInfracao();
    private JInternalFrame frame;

    public InfracaoListagemListenner(JButton listar, JButton novo, JDesktopPane jDesktopPane, JInternalFrame frame) {
        super(listar, novo);
        this.jDesktopPane = jDesktopPane;
        this.frame = frame;
    }

    @Override
    public void eventoListar() {
        System.out.println("Infracao -> Listar");
    }

    @Override
    public void eventoNovo() {
        frame.dispose();
        System.out.println("Infracao -> Novo");
        jDesktopPane.add(telaInfracao);
        telaInfracao.setVisible(true);
    }
}

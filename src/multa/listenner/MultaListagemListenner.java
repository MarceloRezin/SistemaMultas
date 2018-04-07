package multa.listenner;

import commons.listenners.ListagemListenner;
import infracao.telas.TelaInfracao;
import multa.telas.TelaMulta;

import javax.swing.*;

public class MultaListagemListenner extends ListagemListenner {

    private JDesktopPane jDesktopPane;
    private TelaMulta telaMulta = new TelaMulta();
    private JInternalFrame frame;

    public MultaListagemListenner(JButton listar, JButton novo, JDesktopPane jDesktopPane, JInternalFrame frame) {
        super(listar, novo);
        this.jDesktopPane = jDesktopPane;
        this.frame = frame;
    }

    @Override
    public void eventoListar() {
        System.out.println("Multa -> Listar");
    }

    @Override
    public void eventoNovo() {
        frame.dispose();
        System.out.println("Multa -> Novo");
        jDesktopPane.add(telaMulta);
        telaMulta.setVisible(true);
    }
}

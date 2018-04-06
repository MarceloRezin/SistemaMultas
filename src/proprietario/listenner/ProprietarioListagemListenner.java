package proprietario.listenner;

import commons.listenners.ListagemListenner;
import proprietario.telas.TelaProprietario;

import javax.swing.*;

public class ProprietarioListagemListenner extends ListagemListenner {

    private JDesktopPane jDesktopPane;
    private TelaProprietario telaProprietario = new TelaProprietario();
    private JInternalFrame frame;

    public ProprietarioListagemListenner(JButton listar, JButton novo, JDesktopPane jDesktopPane, JInternalFrame frame) {
        super(listar, novo);
        this.jDesktopPane = jDesktopPane;
        this.frame = frame;
    }

    @Override
    public void eventoListar() {
        System.out.println("Proprietário -> Listar");
    }

    @Override
    public void eventoNovo() {
        frame.dispose();
        System.out.println("Proprietário -> Novo");
        jDesktopPane.add(telaProprietario);
        telaProprietario.setVisible(true);
    }
}

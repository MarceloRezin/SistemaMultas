package proprietario.listenner;

import commons.listenners.ListagemListenner;

import javax.swing.*;

public class ProprietarioListagemListenner extends ListagemListenner {

    public ProprietarioListagemListenner(JButton listar, JButton novo) {
        super(listar, novo);
    }

    @Override
    public void eventoListar() {
        System.out.println("Proprietário -> Listar");
    }

    @Override
    public void eventoNovo() {
        System.out.println("Proprietário -> Novo");
    }
}

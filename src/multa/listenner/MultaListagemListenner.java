package multa.listenner;

import commons.listenners.ListagemListenner;

import javax.swing.*;

public class MultaListagemListenner extends ListagemListenner {

    public MultaListagemListenner(JButton listar, JButton novo) {
        super(listar, novo);
    }

    @Override
    public void eventoListar() {
        System.out.println("Multa -> Listar");
    }

    @Override
    public void eventoNovo() {
        System.out.println("Multa -> Novo");
    }
}

package infracao.listenner;

import commons.listenners.ListagemListenner;

import javax.swing.*;

public class InfracaoListagemListenner extends ListagemListenner {
    public InfracaoListagemListenner(JButton listar, JButton novo) {
        super(listar, novo);
    }

    @Override
    public void eventoListar() {
        System.out.println("Infracao -> Listar");
    }

    @Override
    public void eventoNovo() {
        System.out.println("Infracao -> Novo");
    }
}

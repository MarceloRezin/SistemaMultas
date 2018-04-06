package veiculo.listenner;

import commons.listenners.ListagemListenner;

import javax.swing.*;

public class VeiculoListagemListenner extends ListagemListenner {

    public VeiculoListagemListenner(JButton listar, JButton novo) {
        super(listar, novo);
    }

    @Override
    public void eventoListar() {
        System.out.println("Veículo -> Listar");
    }

    @Override
    public void eventoNovo() {
        System.out.println("Veículo -> Novo");
    }
}

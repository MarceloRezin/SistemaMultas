package veiculo.listenner;

import commons.listenners.ListagemListenner;

import javax.swing.*;

public class VeiculoListagemListenner extends ListagemListenner {

    public VeiculoListagemListenner(JButton listar, JButton novo, JButton salvar, JButton excluir) {
        super(listar, novo, salvar, excluir);
    }

    @Override
    public void eventoListar() {
        System.out.println("Veículo -> Listar");
    }

    @Override
    public void eventoNovo() {
        System.out.println("Veículo -> Novo");
    }

    @Override
    public void executaSalvar() {
        System.out.println("Veículo -> Salvar");
    }

    @Override
    public void executarExcluir() {
        System.out.println("Veículo -> Excluir");
    }
}

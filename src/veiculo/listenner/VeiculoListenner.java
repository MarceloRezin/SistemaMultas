package veiculo.listenner;

import commons.telas.CrudListenner;

import javax.swing.*;

public class VeiculoListenner extends CrudListenner{

    public VeiculoListenner(JButton listar, JButton novo, JButton salvar, JButton excluir) {
        super(listar, novo, salvar, excluir);
    }

    @Override
    public void executarListar() {
        System.out.println("Veículo -> Listar");
    }

    @Override
    public void executaNovo() {
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

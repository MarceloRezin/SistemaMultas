package infracao.listenner;

import commons.telas.CrudListenner;

import javax.swing.*;

public class InfracaoListenner extends CrudListenner {
    public InfracaoListenner(JButton listar, JButton novo, JButton salvar, JButton excluir) {
        super(listar, novo, salvar, excluir);
    }

    @Override
    public void executarListar() {
        System.out.println("Infracao -> Listar");
    }

    @Override
    public void executaNovo() {
        System.out.println("Infracao -> Novo");
    }

    @Override
    public void executaSalvar() {
        System.out.println("Infracao -> Salvar");
    }

    @Override
    public void executarExcluir() {
        System.out.println("Infracao -> Excluir");
    }
}

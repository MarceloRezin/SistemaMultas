package infracao.listenner;

import commons.enuns.telas.CrudJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfracaoListenner extends CrudJFrame{
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

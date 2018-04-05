package multa.listenner;

import commons.telas.CrudListenner;

import javax.swing.*;

public class MultaListenner extends CrudListenner{

    public MultaListenner(JButton listar, JButton novo, JButton salvar, JButton excluir) {
        super(listar, novo, salvar, excluir);
    }

    @Override
    public void executarListar() {
        System.out.println("Multa -> Listar");
    }

    @Override
    public void executaNovo() {
        System.out.println("Multa -> Novo");
    }

    @Override
    public void executaSalvar() {
        System.out.println("Multa -> Salvar");
    }

    @Override
    public void executarExcluir() {
        System.out.println("Multa -> Excluir");
    }
}

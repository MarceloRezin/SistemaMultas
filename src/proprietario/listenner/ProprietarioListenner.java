package proprietario.listenner;

import commons.telas.CrudListenner;

import javax.swing.*;

public class ProprietarioListenner extends CrudListenner{

    public ProprietarioListenner(JButton listar, JButton novo, JButton salvar, JButton excluir) {
        super(listar, novo, salvar, excluir);
    }

    @Override
    public void executarListar() {
        System.out.println("Proprietário -> Listar");
    }

    @Override
    public void executaNovo() {
        System.out.println("Proprietário -> Novo");
    }

    @Override
    public void executaSalvar() {
        System.out.println("Proprietário -> Savar");
    }

    @Override
    public void executarExcluir() {
        System.out.println("Proprietário -> Excluir");
    }
}

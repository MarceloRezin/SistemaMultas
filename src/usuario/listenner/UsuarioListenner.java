package usuario.listenner;

import commons.telas.CrudListenner;

import javax.swing.*;

public class UsuarioListenner extends CrudListenner{

    public UsuarioListenner(JButton listar, JButton novo, JButton salvar, JButton excluir) {
        super(listar, novo, salvar, excluir);
    }

    @Override
    public void executarListar() {
        System.out.println("Usuário -> Listar");
    }

    @Override
    public void executaNovo() {
        System.out.println("Usuário -> Novo");
    }

    @Override
    public void executaSalvar() {
        System.out.println("Usuário -> Salvar");
    }

    @Override
    public void executarExcluir() {
        System.out.println("Usuário -> Excluir");
    }
}

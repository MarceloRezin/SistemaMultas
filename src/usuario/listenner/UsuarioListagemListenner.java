package usuario.listenner;

import commons.listenners.ListagemListenner;

import javax.swing.*;

public class UsuarioListagemListenner extends ListagemListenner {

    public UsuarioListagemListenner(JButton listar, JButton novo) {
        super(listar, novo);
    }

    @Override
    public void eventoListar() {
        System.out.println("Usuário -> Listar");
    }

    @Override
    public void eventoNovo() {
        System.out.println("Usuário -> Novo");
    }
}

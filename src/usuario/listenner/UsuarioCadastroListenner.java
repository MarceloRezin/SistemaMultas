package usuario.listenner;

import javax.swing.*;

import commons.listenners.CadastroListenner;
import commons.listenners.ConsultaListenner;

public class UsuarioCadastroListenner extends CadastroListenner {

    public UsuarioCadastroListenner(JButton listar, JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Usuário -> Salvar");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Usuário -> Excluir");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Usuário -> Voltar");
    }
}

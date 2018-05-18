package usuario.listenner;

import javax.swing.*;
import commons.listenners.CadastroListenner;
import log.Logger;

public class UsuarioCadastroListenner extends CadastroListenner {

    public UsuarioCadastroListenner(JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Usuário -> Salvar");
        Logger.log("Usuario, Salvou");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Usuário -> Excluir");
        Logger.log("Usuario, Excluiu");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Usuário -> Voltar");
    }
}

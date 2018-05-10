package usuario.listenner;

import javax.swing.*;
import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;

public class UsuarioCadastroListenner extends CadastroListenner {

    public UsuarioCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
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

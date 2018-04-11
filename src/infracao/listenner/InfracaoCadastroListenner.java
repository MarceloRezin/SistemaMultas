package infracao.listenner;

import javax.swing.*;
import commons.listenners.CadastroListenner;

public class InfracaoCadastroListenner extends CadastroListenner {

    public InfracaoCadastroListenner(JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Infracao -> Salvar");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Infracao -> Excluir");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Infracao -> Voltar");
    }
}

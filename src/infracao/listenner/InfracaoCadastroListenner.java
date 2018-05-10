package infracao.listenner;

import javax.swing.*;
import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;

public class InfracaoCadastroListenner extends CadastroListenner {

    public InfracaoCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
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

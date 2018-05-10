package multa.listenner;

import javax.swing.*;
import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;

public class MultaCadastroListenner extends CadastroListenner {


    public MultaCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Multa -> Salvar");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Multa -> Excluir");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Multa -> Voltar");
    }
}

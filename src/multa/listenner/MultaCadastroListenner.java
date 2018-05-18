package multa.listenner;

import javax.swing.*;
import commons.listenners.CadastroListenner;
import log.Logger;

public class MultaCadastroListenner extends CadastroListenner {

    public MultaCadastroListenner(JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
    }

    @Override
    public void eventoSalvar() {

        System.out.println("Multa -> Salvar");
        Logger.log("Multa, Salvou");

    }

    @Override
    public void eventoExcluir() {
        System.out.println("Multa -> Excluir");
        Logger.log("Multa, Excluiu");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Multa -> Voltar");
    }
}

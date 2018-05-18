package infracao.listenner;

import javax.swing.*;
import commons.listenners.CadastroListenner;
import log.Logger;

public class InfracaoCadastroListenner extends CadastroListenner {

    public InfracaoCadastroListenner(JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Infracao -> Salvar");
        Logger.log("Infração, Salvou");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Infracao -> Excluir");
        Logger.log("Infração, Excluiu");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Infracao -> Voltar");
    }
}

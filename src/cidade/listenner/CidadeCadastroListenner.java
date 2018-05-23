package infracao.listenner;

import javax.swing.*;
import commons.listenners.CadastroListenner;
import log.Logger;

public class CidadeCadastroListenner extends CadastroListenner {

    public CidadeCadastroListenner(JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Cidade -> Salvar");
        Logger.log("Cidade, Salvou");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Cidade -> Excluir");
        Logger.log("Cidade, Excluiu");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Cidade -> Voltar");
    }
}

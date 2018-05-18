package proprietario.listenner;

import javax.swing.*;

import commons.listenners.CadastroListenner;
import log.Logger;

public class ProprietarioCadastroListenner extends CadastroListenner {

    public ProprietarioCadastroListenner(JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
    }

    @Override
    public void eventoSalvar() {

        System.out.println("Proprietário -> Savar");
        Logger.log("Proprietario, Salvou");
    }

    @Override
    public void eventoExcluir() {

        System.out.println("Proprietário -> Excluir");
        Logger.log("Proprietario, Excluiu");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Proprietário -> Voltar");
    }
}

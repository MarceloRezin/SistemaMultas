package proprietario.listenner;

import javax.swing.*;

import commons.listenners.CadastroListenner;

public class ProprietarioCadastroListenner extends CadastroListenner {

    public ProprietarioCadastroListenner(JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Proprietário -> Savar");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Proprietário -> Excluir");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Proprietário -> Voltar");
    }
}

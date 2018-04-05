package proprietario.listenner;

import commons.listenners.CadastroListenner;
import commons.listenners.ListagemListenner;

import javax.swing.*;

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

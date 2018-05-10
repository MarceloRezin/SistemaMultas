package proprietario.listenner;

import javax.swing.*;

import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;

public class ProprietarioCadastroListenner extends CadastroListenner {

    public ProprietarioCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
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

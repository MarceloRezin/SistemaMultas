package cadastros.proprietario.listenner;

import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;
import log.Logger;

public class ProprietarioCadastroListenner extends CadastroListenner {

    public ProprietarioCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
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

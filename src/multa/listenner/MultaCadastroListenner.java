package multa.listenner;

import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;
import log.Logger;

public class MultaCadastroListenner extends CadastroListenner {


    public MultaCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
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

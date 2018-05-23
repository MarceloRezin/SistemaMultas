package infracao.listenner;

import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;
import log.Logger;

public class InfracaoCadastroListenner extends CadastroListenner {

    public InfracaoCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
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

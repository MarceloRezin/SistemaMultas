package orgao.listenner;

import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;
import log.Logger;

public class OrgaoCadastroListenner extends CadastroListenner{

    public OrgaoCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
    }

    @Override
    public void eventoSalvar() {

        System.out.println("Orgão -> Salvar");
        Logger.log("Orgão, Salvou");
    }

    @Override
    public void eventoExcluir() {

        System.out.println("Orgão -> Excluir");
        Logger.log("Orgão, Excluiu");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Orgão -> Voltar");
    }
}

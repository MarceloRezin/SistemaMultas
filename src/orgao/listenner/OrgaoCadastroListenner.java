package orgao.listenner;

import javax.swing.*;

import commons.listenners.CadastroListenner;
import log.Logger;

public class OrgaoCadastroListenner extends CadastroListenner{

    public OrgaoCadastroListenner(JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
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

package orgao.listenner;

import javax.swing.*;

import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;

public class OrgaoCadastroListenner extends CadastroListenner{

    public OrgaoCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Orgão -> Salvar");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Orgão -> Excluir");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Orgão -> Voltar");
    }
}

package orgao.listenner;

import commons.listenners.CadastroListenner;
import commons.listenners.ListagemListenner;

import javax.swing.*;

public class OrgaoCadastroListenner extends CadastroListenner{

    public OrgaoCadastroListenner(JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
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

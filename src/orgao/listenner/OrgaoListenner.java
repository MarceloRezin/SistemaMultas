package orgao.listenner;

import commons.telas.CrudListenner;

import javax.swing.*;

public class OrgaoListenner extends CrudListenner{

    public OrgaoListenner(JButton listar, JButton novo, JButton salvar, JButton excluir) {
        super(listar, novo, salvar, excluir);
    }

    @Override
    public void executarListar() {
        System.out.println("Orgão -> Listar");
    }

    @Override
    public void executaNovo() {
        System.out.println("Orgão -> Novo");
    }

    @Override
    public void executaSalvar() {
        System.out.println("Orgão -> Salvar");
    }

    @Override
    public void executarExcluir() {
        System.out.println("Orgão -> Excluir");
    }
}

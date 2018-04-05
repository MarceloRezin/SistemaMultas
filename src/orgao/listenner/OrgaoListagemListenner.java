package orgao.listenner;

import commons.listenners.ListagemListenner;

import javax.swing.*;

public class OrgaoListagemListenner extends ListagemListenner {

    public OrgaoListagemListenner(JButton listar, JButton novo) {
        super(listar, novo);
    }

    @Override
    public void eventoListar() {
        System.out.println("Orgão -> Listar");
    }

    @Override
    public void eventoNovo() {
        System.out.println("Orgão -> Novo");
    }
}

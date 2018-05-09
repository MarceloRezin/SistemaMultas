package gravidademulta.listenner;

import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;
import gravidademulta.GravidadeMulta;

import javax.swing.*;

public class GravidadeMultaCadastroListenner extends CadastroListenner {

    public GravidadeMultaCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Gravidade Multa -> Excluir");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Gravidade Multa -> Voltar");
    }
}

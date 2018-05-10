package veiculo.listenner;

import javax.swing.*;

import commons.listenners.CadastroListenner;
import commons.listenners.ConsultaListenner;
import commons.telas.CadastroTela;

public class VeiculoCadastroListenner extends CadastroListenner {

    public VeiculoCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Veículo -> Salvar");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Veículo -> Excluir");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Veículo -> Voltar");
    }
}

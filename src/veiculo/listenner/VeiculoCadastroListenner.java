package veiculo.listenner;

import javax.swing.*;

import commons.listenners.CadastroListenner;
import log.Logger;

public class VeiculoCadastroListenner extends CadastroListenner {

    public VeiculoCadastroListenner(JButton listar, JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
    }

    @Override
    public void eventoSalvar() {

        System.out.println("Veículo -> Salvar");
        Logger.log("Veiculo, Salvou");
    }

    @Override
    public void eventoExcluir() {

        System.out.println("Veículo -> Excluir");
        Logger.log("Veiculo, Excluiu");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Veículo -> Voltar");
    }
}
